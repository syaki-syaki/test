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

class RepositoryListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button

    private val repositoryAdapter = RepositoryAdapter { repository ->
        // リポジトリクリック時の処理
        val intent = Intent(this, IssueListActivity::class.java).apply {
            putExtra("repositoryName", "${repository.owner.login}/${repository.name}")
            putExtra("fromActivity", "RepositoryListActivity") // 遷移元を指定
        }
        startActivity(intent)
    }


    private var currentPage = 1 // 現在のページ番号
    private var hasNextPage = true // 次のページが存在するか
    private lateinit var query: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)

        val repositoryName = intent.getStringExtra("repositoryName") ?: ""
        val keyword = intent.getStringExtra("keyword") // キーワードを取得

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = repositoryAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        loadRepositories(repositoryName, keyword)

        // 次のページボタン
        nextPageButton.setOnClickListener {
            if (hasNextPage) {
                currentPage++
                loadRepositories(repositoryName, keyword)
            } else {
                Toast.makeText(this, "次のページはありません", Toast.LENGTH_SHORT).show()
            }
        }

        // 前のページボタン
        prevPageButton.setOnClickListener {
            if (currentPage > 1) {
                currentPage--
                loadRepositories(repositoryName, keyword)
            } else {
                Toast.makeText(this, "前のページはありません", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadRepositories(repositoryName: String, keyword: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // GitHubApiServiceにリポジトリ名とキーワードを渡して検索
                val (repositories, nextPageAvailable) = GitHubApiService.searchRepositoriesWithKeyword(
                    this@RepositoryListActivity,
                    repositoryName,
                    keyword,
                    currentPage // 現在のページ番号を渡す
                )
                withContext(Dispatchers.Main) {
                    if (repositories.isNotEmpty()) {
                        repositoryAdapter.setRepositories(repositories)
                        hasNextPage = nextPageAvailable
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

    private fun updatePagingButtons() {
        // ボタンの有効/無効を更新
        prevPageButton.isEnabled = currentPage > 1
        nextPageButton.isEnabled = hasNextPage
    }
}
