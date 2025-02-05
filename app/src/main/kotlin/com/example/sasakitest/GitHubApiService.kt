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
    private const val BASE_URL = "https://api.github.com/graphql"
    private val client = OkHttpClient()
    private val lastEndCursorMap = mutableMapOf<String, String?>()

    private fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("GitHubToken", "") ?: ""
        Log.d("GitHubApiService", "Retrieved Token: ${token.take(10)}...")
        if (token.isEmpty()) {
            throw IllegalStateException("GitHub Token is not set")
        }
        return token
    }

    // ✅ イシューの編集
    fun editIssue(context: Context, repositoryName: String, issueId: String, title: String, body: String) {
        val token = getToken(context)

        val query = """
        mutation {
          updateIssue(input: {id: "$issueId", title: "$title", body: "$body"}) {
            issue {
              id
              title
              body
            }
          }
        }
        """.trimIndent()

        sendGraphQLRequest(token, query)
    }

    // ✅ イシューの削除
    fun deleteIssue(context: Context, repositoryName: String, issueId: String) {
        val token = getToken(context)

        val query = """
        mutation {
          deleteIssue(input: {issueId: "$issueId"}) {
            clientMutationId
          }
        }
        """.trimIndent()

        sendGraphQLRequest(token, query)
    }


    fun getUserRepositories(context: Context): List<RepositoryResponse.Item> {
        val token = getToken(context)

        val sharedPreferences = context.getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("GitHubUsername", "") ?: ""

        if (username.isEmpty()) {
            throw IllegalStateException("GitHubのユーザー名が設定されていません。")
        }

        val query = """
        {
          search(query: "user:$username", type: REPOSITORY, first: 100) {
            edges {
              node {
                ... on Repository {
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
        }
        """.trimIndent()

        val response = sendGraphQLRequest(token, query)
        val graphQLResponse = Gson().fromJson(response, RepositoryResponse::class.java)

        return graphQLResponse.data.search.edges.map { edge ->
            RepositoryResponse.Item(
                id = edge.node.id,
                name = edge.node.name,
                description = edge.node.description,
                htmlUrl = edge.node.url,
                owner = RepositoryResponse.Owner(edge.node.owner.login)
            )
        }
    }
    // ✅ イシューを取得
    fun getIssues(context: Context, repositoryName: String, currentPage: Int, perPage: Int): List<Issue> {
        val token = getToken(context)

        if (!repositoryName.contains("/")) {
            throw Exception("Invalid repositoryName format: $repositoryName")
        }

        val owner = repositoryName.split("/")[0]
        val name = repositoryName.split("/")[1]

        // `page > 1` の場合は `endCursor` を取得、それ以外は `null`
        val afterCursor = if (currentPage > 1) lastEndCursorMap["issues"]?.let { "\"$it\"" } ?: "null" else "null"

        val query = """
        {
          repository(owner: "$owner", name: "$name") {
            issues(first: $perPage, after: $afterCursor, states: OPEN) {
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

        val response = sendGraphQLRequest(token, query)
        val graphQLResponse = Gson().fromJson(response, GraphQLIssueResponse::class.java)

        // `endCursor` を保存し、次のページ用に使用
        lastEndCursorMap["issues"] = graphQLResponse.data.repository.issues.pageInfo.endCursor

        return graphQLResponse.data.repository.issues.edges.map { edge ->
            Issue(
                id = edge.node.id,
                title = edge.node.title,
                body = edge.node.body
            )
        }
    }

    // ✅ リポジトリ検索
    fun searchRepositoriesWithKeyword(
        context: Context,
        repositoryName: String?, // 🔹 repositoryName を追加
        keyword: String?,
        currentPage: Int
    ): Pair<List<RepositoryResponse.Item>, Boolean> {
        val token = getToken(context)

        // `currentPage > 1` の場合は `endCursor` を取得、それ以外は `null`
        val afterCursor = if (currentPage > 1) lastEndCursorMap["search"] ?: "null" else "null"

        // 🔹 `repositoryName` がある場合、それを検索条件に含める
        val searchQuery = if (!repositoryName.isNullOrEmpty()) {
            "$repositoryName ${keyword ?: ""}"
        } else {
            keyword ?: ""
        }

        val query = """
    {
      search(query: "$searchQuery", type: REPOSITORY, first: 25, after: $afterCursor) {
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

        val response = sendGraphQLRequest(token, query)
        val graphQLResponse = Gson().fromJson(response, RepositoryResponse::class.java)

        // `endCursor` を保存し、次のページ取得用に使用
        lastEndCursorMap["search"] = graphQLResponse.data.search.pageInfo.endCursor

        return Pair(graphQLResponse.data.search.edges.map { edge ->
            RepositoryResponse.Item(
                id = edge.node.id,
                name = edge.node.name,
                description = edge.node.description,
                htmlUrl = edge.node.url,
                owner = RepositoryResponse.Owner(edge.node.owner.login)
            )
        }, graphQLResponse.data.search.pageInfo.hasNextPage)
    }


    fun createIssue(context: Context, repositoryName: String, title: String, body: String) {
        val token = getToken(context)

        val query = """
        mutation {
          createIssue(input: {repositoryId: "$repositoryName", title: "$title", body: "$body"}) {
            issue {
              id
              title
              body
            }
          }
        }
        """.trimIndent()

        sendGraphQLRequest(token, query)
    }


    // 🔹 GraphQL API 送信メソッド
    private fun sendGraphQLRequest(token: String, query: String): String {
        val jsonQuery = Gson().toJson(mapOf("query" to query))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url(BASE_URL)
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", "application/json")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            val responseBody = response.body?.string()
            Log.d("GitHubApiService", "GraphQL Response: $responseBody")

            if (!response.isSuccessful) {
                throw Exception("GraphQL APIリクエスト失敗: ${response.code}, Response: $responseBody")
            }
            return responseBody ?: "{}"
        }
    }
}
