// CreateIssueActivity.kt
package com.example.sasakitest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateIssueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 親クラスの onCreate メソッドを呼び出す
        setContentView(R.layout.activity_create_issue) // レイアウトを activity_create_issue に設定

        // 前の画面から渡されたリポジトリ名を取得（デフォルトは空文字列）
        val repositoryName = intent.getStringExtra("repositoryName") ?: ""
        val token = getToken() // 保存されている GitHub トークンを取得

        // UI 要素を取得
        val issueTitleEditText = findViewById<EditText>(R.id.issueTitleEditText) // タイトル入力用 EditText
        val issueBodyEditText = findViewById<EditText>(R.id.issueBodyEditText) // 内容入力用 EditText
        val createIssueButton = findViewById<Button>(R.id.createIssueButton) // イシュー作成ボタン

        // ボタンのクリックリスナーを設定
        createIssueButton.setOnClickListener {
            val title = issueTitleEditText.text.toString() // タイトル入力値を取得
            val body = issueBodyEditText.text.toString() // 内容入力値を取得

            // タイトルが空の場合はエラーメッセージを表示
            if (title.isEmpty()) {
                Toast.makeText(this, "タイトルを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // ここで処理を終了
            }

            // コルーチンを使用して非同期で API リクエストを送信
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // GitHub の API を使ってイシューを作成
                    GitHubApiService.createIssue(repositoryName, token, title, body)
                    withContext(Dispatchers.Main) {
                        // 成功時の UI 処理
                        Toast.makeText(this@CreateIssueActivity, "Issueを作成しました", Toast.LENGTH_SHORT).show()
                        finish() // 画面を閉じる
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        // エラー時の UI 処理
                        Toast.makeText(this@CreateIssueActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    // SharedPreferences からトークンを取得するメソッド
    private fun getToken(): String {
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE) // SharedPreferences を取得
        return sharedPreferences.getString("GitHubToken", "") ?: "" // トークンを取得（デフォルトは空文字列）
    }
}
