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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_issue)

        // 前の画面から渡されたリポジトリ名を取得
        val repositoryName = intent.getStringExtra("repositoryName") ?: ""
        val token = getToken()

        // リポジトリ名やトークンが無効な場合
        if (repositoryName.isEmpty() || token.isEmpty()) {
            Toast.makeText(this, "リポジトリ名またはトークンが無効です", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // UI 要素を取得
        val issueTitleEditText = findViewById<EditText>(R.id.issueTitleEditText)
        val issueBodyEditText = findViewById<EditText>(R.id.issueBodyEditText)
        val createIssueButton = findViewById<Button>(R.id.createIssueButton)

        // イシュー作成ボタンのクリックリスナー
        createIssueButton.setOnClickListener {
            val title = issueTitleEditText.text.toString().trim()
            val body = issueBodyEditText.text.toString().trim()

            // タイトルが空の場合はエラーメッセージ
            if (title.isEmpty()) {
                Toast.makeText(this, "タイトルを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 非同期で API リクエストを送信
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // GitHub API でイシューを作成
                    GitHubApiService.createIssue(this@CreateIssueActivity, repositoryName, title, body)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@CreateIssueActivity, "イシューが作成されました", Toast.LENGTH_SHORT).show()
                        finish() // アクティビティを終了
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@CreateIssueActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }

    // SharedPreferences からトークンを取得するメソッド
    private fun getToken(): String {
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE)
        return sharedPreferences.getString("GitHubToken", "") ?: ""
    }
}


