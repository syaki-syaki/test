package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.RepositoryAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// 💬 LINE の「トーク一覧画面」に相当する Activity
class RepositoryListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView // 📌 LINE の「トーク一覧」を表示する UI
    private lateinit var nextPageButton: Button // 📌 「次のトークページ」ボタン
    private lateinit var prevPageButton: Button // 📌 「前のトークページ」ボタン

    // 💬 LINE のトーク一覧（RecyclerView に表示するリスト）
    private val repositoryAdapter = RepositoryAdapter { repository ->
        // 💬 ユーザーがトーク（リポジトリ）をクリックしたときの処理
        val intent = Intent(this, IssueListActivity::class.java).apply {
            putExtra(
                "repositoryName",
                "${repository.owner.login}/${repository.name}"
            ) // 📌 トーク（リポジトリ）の情報を渡す
            putExtra("fromActivity", "RepositoryListActivity") // 📌 どの画面から遷移したかを記録
        }
        startActivity(intent) // 📌 LINE でいうと「トーク詳細画面（チャット画面）へ移動」
    }

    private var currentPage = 1 // 📌 現在のページ（LINE でいう「今見ているトーク一覧のページ」）
    private var hasNextPage = true // 📌 次のページがあるか（LINE でいう「次のトークがあるか」）
    private lateinit var query: String // 📌 検索クエリ（トーク検索用のキーワード）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list) // 📌 トーク一覧のレイアウトをセット

        // 💬 画面遷移時に受け取った「トーク名（リポジトリ名）」と「検索キーワード」を取得
        val repositoryName = intent.getStringExtra("repositoryName") ?: "" // 📌 トーク（リポジトリ）名を取得
        val keyword = intent.getStringExtra("keyword") // 📌 検索キーワードを取得（特定のトークを検索）

        // 💬 RecyclerView（トーク一覧）をセットアップ
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // 📌 縦スクロールに設定
        recyclerView.adapter = repositoryAdapter // 📌 RecyclerView に Adapter をセット（LINE のトーク一覧を管理）

        // 💬 ページング用のボタンを取得（「次へ」「前へ」ボタン）
        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        // 💬 初回のトークデータ（リポジトリ一覧）を取得
        loadRepositories(repositoryName, keyword)

        // 💬 「次のページ」ボタンの処理（LINE でいう「次のトークページを開く」）
        nextPageButton.setOnClickListener {
            if (hasNextPage) {
                currentPage++ // 📌 ページを 1 つ増やす
                loadRepositories(repositoryName, keyword) // 📌 新しいトーク一覧を取得
            } else {
                Toast.makeText(this, "次のページはありません", Toast.LENGTH_SHORT)
                    .show() // 📌 「次のトークページはないよ」と通知
            }
        }

        // 💬 「前のページ」ボタンの処理（LINE でいう「前のトークページを開く」）
        prevPageButton.setOnClickListener {
            if (currentPage > 1) {
                currentPage-- // 📌 ページを 1 つ戻す
                loadRepositories(repositoryName, keyword) // 📌 新しいトーク一覧を取得
            } else {
                Toast.makeText(this, "前のページはありません", Toast.LENGTH_SHORT)
                    .show() // 📌 「前のトークページはないよ」と通知
            }
        }
    }



    // 💬 LINE の「トーク一覧を取得する処理」
    // GitHub からリポジトリを取得する関数
    private fun loadRepositories(username: String, keyword: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repositories = GitHubApiService.getRepository(
                    this@RepositoryListActivity,
                    username
                )
                withContext(Dispatchers.Main) {
                    if (repositories.isNotEmpty()) {
                        repositoryAdapter.setRepositories(repositories)
                        hasNextPage = repositories.size == 25
                        updatePagingButtons()
                    } else {
                        Toast.makeText(
                            this@RepositoryListActivity,
                            "該当するリポジトリが見つかりませんでした",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@RepositoryListActivity,
                        "エラー: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    // ページングボタンの有効・無効を更新
    private fun updatePagingButtons() { //㊿
        prevPageButton.isEnabled = currentPage > 1 //㉔ ページが 1 より大きければ「前へ」ボタンを有効化
        nextPageButton.isEnabled = hasNextPage //㉔ 次のページがあるなら「次へ」ボタンを有効化
    }
}