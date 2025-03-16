package com.example.sasakitest

import android.os.Bundle // `Activity` の状態を管理するためのクラス
import android.widget.Button // `Button`（ボタン UI）を扱うためのクラス
import android.widget.EditText // `EditText`（入力フィールド UI）を扱うためのクラス
import android.widget.Toast // 短いメッセージをユーザーに表示するためのクラス
import androidx.appcompat.app.AppCompatActivity // Android の `Activity` の基本クラス
import kotlinx.coroutines.CoroutineScope // コルーチン（非同期処理の範囲）を管理するためのクラス
import kotlinx.coroutines.Dispatchers // `CoroutineScope` でどのスレッドを使うか指定するクラス
import kotlinx.coroutines.launch // 非同期処理を開始する関数
import kotlinx.coroutines.withContext // 別のスレッドに切り替える関数

class CreateIssueActivity : AppCompatActivity() { // `Activity` クラスを継承し、Issue 作成画面を作成
    override fun onCreate(savedInstanceState: Bundle?) { // `Activity` の作成時に呼ばれる
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_issue) // `activity_create_issue.xml` をレイアウトとして適用

        // `Intent` からリポジトリ名を取得（前の画面から渡された値）
        val repositoryName = intent.getStringExtra("repositoryName") ?: "" // `Intent` から `repositoryName` を取得
        val token = getToken() // `SharedPreferences` からトークンを取得

        // リポジトリ名またはトークンが空の場合
        if (repositoryName.isEmpty() || token.isEmpty()) { // データが取得できなかった場合
            Toast.makeText(this, "リポジトリ名またはトークンが無効です", Toast.LENGTH_SHORT).show() // エラーメッセージを表示
            finish() // 画面を終了
            return // これ以降の処理を実行しない
        }

        // 📝 `getStringExtra()` は `Intent` クラスのメソッドで、前の画面から `putExtra()` で渡されたデータを取得する
        // 例: `intent.putExtra("repositoryName", "android_project")` → `intent.getStringExtra("repositoryName")` で `"android_project"` を取得

        // UI 要素を取得（`EditText` や `Button`）
        val issueTitleEditText = findViewById<EditText>(R.id.issueTitleEditText) // イシューのタイトル入力フィールド
        val issueBodyEditText = findViewById<EditText>(R.id.issueBodyEditText) // イシューの本文入力フィールド
        val createIssueButton = findViewById<Button>(R.id.createIssueButton) // 「イシュー作成」ボタン

        // 「イシュー作成」ボタンが押されたときの処理
        createIssueButton.setOnClickListener {
            val title = issueTitleEditText.text.toString().trim() // 入力されたタイトルを取得（前後の空白を削除）
            val body = issueBodyEditText.text.toString().trim() // 入力された本文を取得（前後の空白を削除）

            // 📝 `trim()` は `String` クラスのメソッドで、文字列の前後にある不要な空白を削除する
            // 例: `"  Hello World  ".trim()` → `"Hello World"`

            // タイトルが空の場合はエラーメッセージを表示
            if (title.isEmpty()) {
                Toast.makeText(this, "タイトルを入力してください", Toast.LENGTH_SHORT).show() // ユーザーに警告メッセージを表示
                return@setOnClickListener // これ以降の処理を実行せず終了
            }

            // 非同期で API リクエストを送信
            CoroutineScope(Dispatchers.IO).launch { // `IO` スレッドで API を呼び出す（バックグラウンド処理）
                try {
                    // GitHub API でイシューを作成
                    GitHubApiService.createIssue( // GitHub に Issue 作成リクエストを送信
                        this@CreateIssueActivity, // `Context`（画面情報）を渡す
                        repositoryName, // リポジトリ名
                        title, // ユーザーが入力したタイトル
                        body // ユーザーが入力した本文
                    )
                    withContext(Dispatchers.Main) { // メインスレッドに戻して UI を更新
                        Toast.makeText(this@CreateIssueActivity, "イシューが作成されました", Toast.LENGTH_SHORT).show() // 成功メッセージを表示
                        finish() // 画面を閉じて前の `Activity` に戻る
                    }
                } catch (e: Exception) { // 例外処理（API 呼び出し時のエラー）
                    withContext(Dispatchers.Main) { // UI スレッドでエラーメッセージを表示
                        Toast.makeText(this@CreateIssueActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    // 📝 SharedPreferences からトークンを取得するメソッド
    private fun getToken(): String {
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE) // `SharedPreferences` を取得
        return sharedPreferences.getString("GitHubToken", "") ?: "" // GitHub のアクセストークンを取得（デフォルトは空文字）
    }
}
