// このファイルは、GitHub APIを使ってリポジトリの検索、イシューの取得、イシューの作成を行うサービスを提供します。
// OkHttpを使ったHTTPリクエストでデータをやり取りし、GsonでJSONをオブジェクトに変換して処理します。
// このファイルは、GitHub APIを使ってリポジトリの検索、イシューの取得、イシューの作成を行うサービスを提供します。
// OkHttpを使ったHTTPリクエストでデータをやり取りし、GsonでJSONをオブジェクトに変換して処理します。

package com.example.sasakitest

import com.google.gson.Gson // JSONデータをオブジェクトに変換するためのライブラリ
import okhttp3.MediaType.Companion.toMediaType // リクエストの内容の形式を指定するためのツール
import okhttp3.OkHttpClient // HTTP通信をするためのクライアント
import okhttp3.Request // HTTPリクエストを作るためのクラス
import okhttp3.RequestBody.Companion.toRequestBody // リクエストの本文を簡単に作成するユーティリティ
import com.example.sasakitest.model.Issue // GitHubのイシュー（課題）データを扱うクラス
import com.example.sasakitest.model.RepositoryResponse // リポジトリ検索結果のデータを扱うクラス
import android.util.Log

// GitHub APIを操作するためのサービス
object GitHubApiService {
    private const val BASE_URL = "https://api.github.com" // GitHub APIの基本となるURL

    private val client = OkHttpClient() // HTTP通信を実行するためのクライアントを作成

    // リポジトリを検索するメソッド（ページング対応）
    fun searchRepositories(query: String, token: String, page: Int): Pair<RepositoryResponse, Boolean> {
        val url = "$BASE_URL/search/repositories?q=$query&page=$page&per_page=25"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("APIリクエストが失敗しました: ${response.code}")
            }

            val body = response.body?.string() ?: throw Exception("レスポンスが空です")
            Log.d("GitHubApiService", "Raw API Response: $body")

            val hasNextPage = response.headers["Link"]?.contains("rel=\"next\"") ?: false
            return Pair(Gson().fromJson(body, RepositoryResponse::class.java), hasNextPage)
        }
    }

    // イシュー（課題）を取得するメソッド（ページング対応）
    fun getIssues(repositoryName: String, token: String, page: Int, perPage: Int): List<Issue> {
        val url = "$BASE_URL/repos/$repositoryName/issues?per_page=$perPage&page=$page" // イシュー取得用のURL
        val request = Request.Builder() // リクエストの設定を開始
            .url(url) // URLを設定
            .addHeader("Authorization", "Bearer $token") // 認証用トークンをヘッダーに追加
            .build() // リクエストを完成

        client.newCall(request).execute().use { response -> // リクエストを送ってレスポンスを取得
            if (!response.isSuccessful) { // レスポンスが成功でない場合
                throw Exception("Failed to fetch issues: ${response.code}") // エラーを投げる
            }
            val body = response.body?.string() ?: throw Exception("Empty response") // レスポンス本文を取得
            return Gson().fromJson(body, Array<Issue>::class.java).toList() // JSONをオブジェクトリストに変換して返す
        }
    }

    // 新しいイシューを作成するメソッド
    fun createIssue(repositoryName: String, token: String, title: String, body: String) {
        val url = "$BASE_URL/repos/$repositoryName/issues" // 新規イシュー作成用のURL
        val json = """{ "title": "$title", "body": "$body" }""" // イシュー作成用のJSONデータ
        val requestBody = json.toRequestBody("application/json".toMediaType()) // リクエスト本文を設定
        val request = Request.Builder() // リクエストの設定を開始
            .url(url) // URLを設定
            .addHeader("Authorization", "Bearer $token") // 認証用トークンをヘッダーに追加
            .post(requestBody) // POSTリクエストとして設定
            .build() // リクエストを完成

        client.newCall(request).execute().use { response -> // リクエストを送ってレスポンスを取得
            if (!response.isSuccessful) { // レスポンスが成功でない場合
                throw Exception("Failed to create issue: ${response.code}") // エラーを投げる
            }
        }
    }
}
