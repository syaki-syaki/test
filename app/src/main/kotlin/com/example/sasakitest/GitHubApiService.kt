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
    private const val BASE_URL = "https://api.github.com"
    private val client = OkHttpClient()
    // 🔹 ページング用の `endCursor` をリポジトリごとに管理
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

    // イシューの編集
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

        val jsonQuery = Gson().toJson(mapOf("query" to query))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$BASE_URL/graphql")
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", "application/json")
            .post(requestBody) // GraphQL では POST を使用
            .build()

        client.newCall(request).execute().use { response ->
            val responseBody = response.body?.string()
            Log.d("GitHubApiService", "GraphQL Response: $responseBody")

            if (!response.isSuccessful) {
                throw Exception("GraphQL APIリクエスト失敗: ${response.code}, Response: $responseBody")
            }
        }
    }




    // イシューの削除
    // GitHubApiService.deleteIssue を修正
    fun deleteIssue(context: Context, repositoryName: String, issueId: String) { // 修正: issueNumber → issueId (String)
        val token = getToken(context)

        val query = """
    mutation {
      deleteIssue(input: {issueId: "$issueId", clientMutationId: "delete_$issueId"}) {
        clientMutationId
      }
    }
    """.trimIndent()

        val jsonQuery = Gson().toJson(mapOf("query" to query))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$BASE_URL/graphql")
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", "application/json")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            val body = response.body?.string()
            Log.d("GitHubApiService", "GraphQL Response: $body")

            if (!response.isSuccessful) {
                throw Exception("GraphQL APIリクエスト失敗: ${response.code}, Response: $body")
            }
        }
    }

    fun getIssues(context: Context, repositoryName: String, page: Int, perPage: Int): List<Issue> {
        val token = getToken(context)

        if (!repositoryName.contains("/")) {
            throw Exception("Invalid repositoryName format: $repositoryName")
        }

        val owner = repositoryName.split("/")[0]
        val name = repositoryName.split("/")[1]

        // after の値を endCursor から取得
        val afterCursor = if (page > 1) lastEndCursor?.let { "\"$it\"" } ?: "null" else "null"

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

        val jsonQuery = Gson().toJson(mapOf("query" to query))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$BASE_URL/graphql")
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", "application/json")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            val body = response.body?.string()
            Log.d("GitHubApiService", "GraphQL Response: $body")

            if (!response.isSuccessful) {
                throw Exception("GraphQL APIリクエスト失敗: ${response.code}, Response: $body")
            }

            val graphQLResponse = Gson().fromJson(body, GraphQLIssueResponse::class.java)

            // endCursor を次回のページ取得用に保存
            lastEndCursor = graphQLResponse.data.repository.issues.pageInfo.endCursor

            return graphQLResponse.data.repository.issues.edges.map { edge ->
                Issue(
                    id = edge.node.id,
                    title = edge.node.title,
                    body = edge.node.body
                )
            }
        }
    }

    // endCursor を保存するための変数を定義
    private var lastEndCursor: String? = null



    fun searchRepositoriesWithKeyword(
        context: Context,
        repositoryName: String,
        keyword: String?,
        page: Int
    ): Pair<List<RepositoryResponse.Item>, Boolean> {
        val token = getToken(context)

        // 🔹 `lastEndCursorMap["search"]` に保存された `endCursor` を利用
        val afterCursor = if (page > 1) lastEndCursorMap["search"]?.let { "\"$it\"" } ?: "null" else "null"

        val query = """
    {
      search(query: "$repositoryName ${keyword ?: ""}", type: REPOSITORY, first: 25, after: $afterCursor) {
        pageInfo {
          hasNextPage
          endCursor
        }
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

        val jsonQuery = """{"query": ${Gson().toJson(query)}}"""
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$BASE_URL/graphql")
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", "application/json")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            val body = response.body?.string()
            Log.d("GitHubApiService", "GraphQL Response: $body")

            if (!response.isSuccessful) {
                throw Exception("GraphQL APIリクエスト失敗: ${response.code}, Response: $body")
            }

            val graphQLResponse = Gson().fromJson(body, RepositoryResponse::class.java)

            // 🔹 `endCursor` を保存して、次のページ取得時に利用
            lastEndCursorMap["search"] = graphQLResponse.data.search.pageInfo.endCursor
            Log.d("GitHubApiService", "Updated lastEndCursor for search: ${lastEndCursorMap["search"]}")

            val repositories = graphQLResponse.data.search.edges.map { edge ->
                RepositoryResponse.Item(
                    id = edge.node.id,
                    name = edge.node.name,
                    description = edge.node.description,
                    htmlUrl = edge.node.url,
                    owner = RepositoryResponse.Owner(edge.node.owner.login)
                )
            }

            return Pair(repositories, graphQLResponse.data.search.pageInfo.hasNextPage)
        }
    }



    // イシュー（課題）を取得するメソッド（ページング対応）

    // 新しいイシューを作成するメソッド
    fun getUserRepositories(context: Context): List<RepositoryResponse.Item> {
        val token = getToken(context)

        // GitHubのユーザー名を取得する（SharedPreferencesに保存されている場合）
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

        val jsonQuery = Gson().toJson(mapOf("query" to query))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$BASE_URL/graphql")
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

            val graphQLResponse = Gson().fromJson(responseBody, RepositoryResponse::class.java)

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
    }




    // 新しいイシューを作成する
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

        val jsonQuery = Gson().toJson(mapOf("query" to query))
        val requestBody = jsonQuery.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$BASE_URL/graphql")
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
        }
    }
}