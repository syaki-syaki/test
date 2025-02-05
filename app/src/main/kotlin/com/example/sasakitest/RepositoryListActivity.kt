package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button//nCreate(savedInstanceState: Bundle?自体
import android.widget.Toast//これってアプリ中止させるやつだっけ
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager//BottonとかrecyclerViewとかこのimportから来てるの？
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.RepositoryAdapter
import kotlinx.coroutines.CoroutineScope//これなに
import kotlinx.coroutines.Dispatchers//これもどこのクラスのために使われれるの？
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoryListActivity : AppCompatActivity() {//AppCompatActivity()の存在意義
private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button

    private val repositoryAdapter = RepositoryAdapter { repository ->
        // リポジトリクリック時の処理
        val intent = Intent(this, IssueListActivity::class.java).apply {//(this, IssueListActivity::class.java).apply 個々の部分の１単語ずつの意味教えて
            putExtra("repositoryName", "${repository.owner.login}/${repository.name}")//${repository.owner.login}/${repository.name}のなかにある/の意味
            putExtra("fromActivity", "RepositoryListActivity")
        }
        startActivity(intent)
    }


    private var currentPage = 1
    private var hasNextPage = true //ここでのtrueとは？存在するってこと？
    private lateinit var query: String //何のためにこれ定義したん



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)//activity_repository_listこれは何？

        val repositoryName = intent.getStringExtra("repositoryName") ?: ""
        val keyword = intent.getStringExtra("keyword") // キーワードを取得

        recyclerView = findViewById(R.id.recyclerView)//findViewById(R.id.recyclerView)これ何してるの人単語ずつ意味教えて
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = repositoryAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        loadRepositories(repositoryName, keyword)

        // 次のページボタン
        nextPageButton.setOnClickListener {//nextPageButton はこのクラスの中で定義されてるがの中にsetOnClickListenerのような関数あったけ
            if (hasNextPage) {//hasnextpageってcurrentpageと連携してるの？
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
        CoroutineScope(Dispatchers.IO).launch {//(Dispatchers.IO).launchこれの人単語ずつの意味は
            try {
                // GitHubApiServiceにリポジトリ名とキーワードを渡して検索
                val (repositories, nextPageAvailable) = GitHubApiService.searchRepositoriesWithKeyword(
                    this@RepositoryListActivity,
                    repositoryName,
                    keyword,
                    currentPage // 現在のページ番号を渡す
                )
                withContext(Dispatchers.Main) {
                    if (repositories.isNotEmpty()) {//  withContext(Dispatchers.Main)これの１単語ずつの意味は
                        repositoryAdapter.setRepositories(repositories)
                        hasNextPage = nextPageAvailable
                        updatePagingButtons()
                    } else {
                        Toast.makeText(//
                            this@RepositoryListActivity,//@RepositoryListActivityの@やmakeTextやLENGTH_SHORTはどういう意味
                            "該当するリポジトリが見つかりませんでした",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@RepositoryListActivity,
                        "エラー: ${e.message}",//e.messageのeや{}の意味は　(Dispatchers.Main)の意味は
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
