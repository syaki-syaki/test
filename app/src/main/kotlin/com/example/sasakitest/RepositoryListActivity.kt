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
        }
        startActivity(intent)
    }

    private var currentPage = 1
    private var hasNextPage = true
    private lateinit var query: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)

        query = intent.getStringExtra("query") ?: ""

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = repositoryAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        // 最初のデータ読み込み
        loadRepositories()

        // 次のページボタン
        nextPageButton.setOnClickListener {
            if (hasNextPage) {
                currentPage++
                loadRepositories()
            } else {
                Toast.makeText(this, "次のページはありません", Toast.LENGTH_SHORT).show()
            }
        }

        // 前のページボタン
        prevPageButton.setOnClickListener {
            if (currentPage > 1) {
                currentPage--
                loadRepositories()
            } else {
                Toast.makeText(this, "前のページはありません", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadRepositories() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val (repositoryResponse, nextPageAvailable) =
                    GitHubApiService.searchRepositories(this@RepositoryListActivity, query, currentPage)
                withContext(Dispatchers.Main) {
                    if (repositoryResponse.items.isNotEmpty()) {
                        repositoryAdapter.setRepositories(repositoryResponse.items)
                        hasNextPage = nextPageAvailable
                        updateButtons()
                    } else {
                        Toast.makeText(this@RepositoryListActivity, "リポジトリが見つかりませんでした", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@RepositoryListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun updateButtons() {
        prevPageButton.isEnabled = currentPage > 1
        nextPageButton.isEnabled = hasNextPage
    }
}
