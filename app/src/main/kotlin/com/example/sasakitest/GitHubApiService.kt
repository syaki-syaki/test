// このファイルは、GitHub APIを使ってリポジトリの検索、イシューの取得、イシューの作成を行うサービスを提供します。
// OkHttpを使ったHTTPリクエストでデータをやり取りし、GsonでJSONをオブジェクトに変換して処理します。
// このファイルは、GitHub APIを使ってリポジトリの検索、イシューの取得、イシューの作成を行うサービスを提供します。
// OkHttpを使ったHTTPリクエストでデータをやり取りし、GsonでJSONをオブジェクトに変換して処理します。

package com.example.sasakitest

import android.content.Context
import android.util.Log
import com.example.sasakitest.model.Issue
import com.example.sasakitest.model.RepositoryResponse
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
// GitHub APIを操作するためのサービス
object GitHubApiService {
    private const val BASE_URL = "https://api.github.com"
    private val client = OkHttpClient()

    // トークン取得
    private fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("GitHubToken", "") ?: ""
        Log.d("GitHubApiService", "Retrieved token: $token")
        if (token.isEmpty()) {
            throw IllegalStateException("GitHub Token is not set")
        }
        return token
    }

    // コメントを編集する
    fun editComment(context: Context, repositoryName: String, commentId: Int, newBody: String) {
        val token = getToken(context)
        val url = "$BASE_URL/repos/$repositoryName/issues/comments/$commentId"
        val json = """{ "body": "$newBody" }"""
        val requestBody = json.toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .patch(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Failed to edit comment: ${response.code}")
            }
        }
    }

    // コメントを削除する
    fun deleteComment(context: Context, repositoryName: String, commentId: Int) {
        val token = getToken(context)
        val url = "$BASE_URL/repos/$repositoryName/issues/comments/$commentId"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .delete()
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Failed to delete comment: ${response.code}")
            }
        }
    }


    fun searchRepositories(context: Context, query: String, page: Int): Pair<RepositoryResponse, Boolean> {
        val token = getToken(context)
        val url = "$BASE_URL/search/repositories?q=$query&page=$page&per_page=25"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .build()

        Log.d("GitHubApiService", "API Request URL: $url")

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("API request failed: ${response.code}")
            }
            val body = response.body?.string() ?: throw Exception("Empty response")
            val hasNextPage = response.headers["Link"]?.contains("rel=\"next\"") ?: false
            return Pair(Gson().fromJson(body, RepositoryResponse::class.java), hasNextPage)
        }
    }


    // イシュー（課題）を取得するメソッド（ページング対応）
    fun getIssues(context: Context, repositoryName: String, page: Int, perPage: Int): List<Issue> {
        val token = getToken(context)
        val url = "$BASE_URL/repos/$repositoryName/issues?per_page=$perPage&page=$page"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .build()

        Log.d("GitHubApiService", "Fetching issues with URL: $url for repository: $repositoryName")

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Failed to fetch issues: ${response.code}")
            }
            val body = response.body?.string() ?: throw Exception("Empty response")
            return Gson().fromJson(body, Array<Issue>::class.java).toList()
        }
    }

// 新しいイシューを作成するメソッド
fun createIssue(context: Context, repositoryName: String, title: String, body: String) {
    val token = getToken(context) // context を使ってトークンを取得
    val url = "$BASE_URL/repos/$repositoryName/issues"
    val json = """{ "title": "$title", "body": "$body" }"""
    val requestBody = json.toRequestBody("application/json".toMediaType())
    val request = Request.Builder()
        .url(url)
        .addHeader("Authorization", "Bearer $token")
        .post(requestBody)
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            throw Exception("Failed to create issue: ${response.code}")
        }
    }
}



}




