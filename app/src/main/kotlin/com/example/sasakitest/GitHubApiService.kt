package com.example.sasakitest

import android.content.Context
import android.util.Log
import com.example.sasakitest.model.GraphQLIssueResponse
import com.example.sasakitest.model.Issue
import com.example.sasakitest.model.RepositoryResponse
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

object GitHubApiService {
    private const val BASE_URL = "https://api.github.com/graphql" //
    private val client = OkHttpClient()
    private val lastEndCursorMap = mutableMapOf<String, String?>()

    private fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("AuthToken", "") ?: ""
        Log.d("GraphQLApiService", "Retrieved Token: ${token.take(10)}...")
        if (token.isEmpty()) {
            throw IllegalStateException("API Token is not set")
        }
        return token
    }

    //  ユーザーのリポジトリを取得（完全に `variables` を使用）
    fun getUserRepositories(context: Context): List<RepositoryResponse.Item> {
        val token = getToken(context)

        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("Username", "") ?: ""

        if (username.isEmpty()) {
            throw IllegalStateException("Username is not set.")
        }

        val query = """
        query GetUserRepositories(${"$"}username: String!) {
          search(query: ${"$"}username, type: REPOSITORY, first: 100) {
            edges {
              node {
                id
                name
                description
                url
                owner {
                  login
                }
              }
            }
          }
        }
        """.trimIndent()

        val variables = mapOf("username" to username)
        val response = sendGraphQLRequest(token, query, variables)
        val graphQLResponse = Gson().fromJson(response, RepositoryResponse::class.java)

        return graphQLResponse.toItemList()
    }

    // イシューの取得（完全に `variables` を使用）
    fun getIssues(context: Context, repositoryId: String, currentPage: Int, perPage: Int): List<Issue> {
        val token = getToken(context)
        val afterCursor = if (currentPage > 1) lastEndCursorMap["issues"] ?: null else null

        val query = """
        query GetIssues(${"$"}repositoryId: String!, ${"$"}first: Int!, ${"$"}after: String) {
          repository(id: ${"$"}repositoryId) {
            issues(first: ${"$"}first, after: ${"$"}after) {
              pageInfo {
                hasNextPage
                endCursor
              }
              edges {
                node {
                  id
                  title
                  body
                }
              }
            }
          }
        }
        """.trimIndent()

        val variables = mapOf(
            "repositoryId" to repositoryId,
            "first" to perPage,
            "after" to afterCursor
        )

        val response = sendGraphQLRequest(token, query, variables)
        val graphQLResponse = Gson().fromJson(response, GraphQLIssueResponse::class.java)

        lastEndCursorMap["issues"] = graphQLResponse.data.repository.issues.pageInfo.endCursor

        return graphQLResponse.data.repository.issues.edges.map { edge ->
            Issue(
                id = edge.node.id,
                title = edge.node.title,
                body = edge.node.body
            )
        }
    }

    //  リポジトリ検索（完全に `variables` を使用）
    fun searchRepositoriesWithKeyword(
        context: Context,
        repositoryName: String?,
        keyword: String?,
        currentPage: Int
    ): Pair<List<RepositoryResponse.Item>, Boolean> {
        val token = getToken(context)
        val afterCursor = if (currentPage > 1) lastEndCursorMap["search"] ?: null else null

        val searchQuery = if (!repositoryName.isNullOrEmpty()) {
            "$repositoryName ${keyword ?: ""}"
        } else {
            keyword ?: ""
        }

        val query = """
        query SearchRepositories(${"$"}query: String!, ${"$"}first: Int!, ${"$"}after: String) {
          search(query: ${"$"}query, type: REPOSITORY, first: ${"$"}first, after: ${"$"}after) {
            pageInfo {
              hasNextPage
              endCursor
            }
            edges {
              node {
                id
                name
                description
                url
                owner {
                  login
                }
              }
            }
          }
        }
        """.trimIndent()

        val variables = mapOf(
            "query" to searchQuery,
            "first" to 25,
            "after" to afterCursor
        )

        val response = sendGraphQLRequest(token, query, variables)
        val graphQLResponse = Gson().fromJson(response, RepositoryResponse::class.java)

        lastEndCursorMap["search"] = graphQLResponse.data.search.pageInfo.endCursor

        return Pair(graphQLResponse.toItemList(), graphQLResponse.data.search.pageInfo.hasNextPage)
    }

    // ✅ イシューの編集（完全に `variables` を使用）
    fun editIssue(context: Context, issueId: String, title: String, body: String?) {
        val token = getToken(context)

        val query = """
        mutation EditIssue(${"$"}issueId: String!, ${"$"}title: String!, ${"$"}body: String) {
          updateIssue(input: {id: ${"$"}issueId, title: ${"$"}title, body: ${"$"}body}) {
            issue {
              id
              title
              body
            }
          }
        }
        """.trimIndent()

        val variables = mapOf(
            "issueId" to issueId,
            "title" to title,
            "body" to body
        )

        sendGraphQLRequest(token, query, variables)
    }
    fun createIssue(context: Context, repositoryId: String, title: String, body: String?) {
        val token = getToken(context)

        val query = """
    mutation CreateIssue(${"$"}repositoryId: String!, ${"$"}title: String!, ${"$"}body: String) {
      createIssue(repositoryId: ${"$"}repositoryId, title: ${"$"}title, body: ${"$"}body) {
        issue {
          id
          title
          body
        }
      }
    }
    """.trimIndent()

        val variables = mapOf("repositoryId" to repositoryId, "title" to title, "body" to body)
        sendGraphQLRequest(token, query, variables)
    }
    fun deleteIssue(context: Context, issueId: String) {
        val token = getToken(context)

        val query = """
    mutation DeleteIssue(${"$"}issueId: String!) {
      deleteIssue(issueId: ${"$"}issueId) {
        success
        message
      }
    }
    """.trimIndent()

        val variables = mapOf("issueId" to issueId)

        sendGraphQLRequest(token, query, variables)
    }


    // ✅ 汎用的な GraphQL API 送信メソッド
    private fun sendGraphQLRequest(token: String, query: String, variables: Map<String, Any?>): String {
        val jsonQuery = Gson().toJson(mapOf("query" to query, "variables" to variables))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url(BASE_URL)
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", "application/json")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            val responseBody = response.body?.string()
            Log.d("GraphQLApiService", "GraphQL Response: $responseBody")

            if (!response.isSuccessful) {
                throw Exception("GraphQL APIリクエスト失敗: ${response.code}, Response: $responseBody")
            }
            return responseBody ?: "{}"
        }
    }
}
