// このファイルはGitHubのリポジトリ一覧を表示する画面を提供します。
// リポジトリを取得し、RecyclerViewを使ってリスト表示します。ページング処理を実装し、次のページをロードする機能もあります。

package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.sasakitest.adapter.RepositoryAdapter
import com.example.sasakitest.model.RepositoryResponse

class RepositoryListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView // リポジトリを表示するRecyclerView
    private val repositoryAdapter = RepositoryAdapter(
        onClick = { repository -> // リポジトリがクリックされたときの処理
            val intent = Intent(this, IssueListActivity::class.java) // IssueListActivityに遷移
            intent.putExtra("repositoryName", repository.name) // リポジトリ名を渡す
            startActivity(intent) // 次の画面を開く
        },
        onNextPageClick = { loadNextPage() } // 次のページをロードする処理
    )

    private var currentPage = 1 // 現在のページ番号
    private var hasNextPage = true // 次のページがあるかどうか
    private lateinit var query: String // 検索クエリ
    private lateinit var token: String // 認証トークン

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 親クラスの初期化
        setContentView(R.layout.activity_repository_list) // レイアウトを設定

        query = intent.getStringExtra("query") ?: "" // インテントから検索クエリを取得
        token = getToken() // トークンを取得

        // RecyclerViewを初期化
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // 縦スクロールのレイアウトを設定
        recyclerView.adapter = repositoryAdapter // アダプターを設定

        // クエリやトークンが無効な場合はエラーメッセージを表示して終了
        if (query.isEmpty() || token.isEmpty()) {
            Toast.makeText(this, "クエリまたはトークンが無効です", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        loadRepositories() // リポジトリを初期ロード
    }

    // リポジトリをロードするメソッド
    private fun loadRepositories() {
        Log.d("RepositoryListActivity", "Current page at start of loadRepositories: $currentPage")
        if (!hasNextPage) { // 次のページがない場合はメッセージを表示して終了
            Log.d("RepositoryListActivity", "No more pages to fetch.")
            Toast.makeText(this, "これ以上のページはありません", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("RepositoryListActivity", "Fetching page: $currentPage")
        CoroutineScope(Dispatchers.IO).launch { // 非同期処理でリポジトリを取得
            try {
                val (repositoryResponse, nextPageAvailable) = GitHubApiService.searchRepositories(query, token, currentPage) // GitHub APIを呼び出し

                withContext(Dispatchers.Main) { // メインスレッドでUIを更新
                    Log.d("RepositoryListActivity", "API Response: ${repositoryResponse.items}")
                    if (repositoryResponse.items.isNotEmpty()) { // データが空でない場合
                        repositoryAdapter.addRepositories(repositoryResponse.items) // アダプターにデータを追加
                        currentPage++ // ページ番号を次に進める
                        hasNextPage = nextPageAvailable // 次のページの有無を確認
                        Log.d("RepositoryListActivity", "Fetched ${repositoryResponse.items.size} repositories. Next page available: $hasNextPage")
                    } else { // データが空の場合
                        hasNextPage = false
                        Log.d("RepositoryListActivity", "No more items fetched.")
                    }
                }
            } catch (e: Exception) { // エラーが発生した場合
                withContext(Dispatchers.Main) { // メインスレッドでエラーを表示
                    Log.e("RepositoryListActivity", "Error fetching repositories: ${e.message}")
                    Toast.makeText(this@RepositoryListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // 次のページをロードするメソッド
    private fun loadNextPage() {
        Log.d("RepositoryListActivity", "Current page at start of loadNextPage: $currentPage")
        loadRepositories() // 次のページをロード
    }

    // トークンを取得するメソッド
    private fun getToken(): String {
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE) // SharedPreferencesからトークンを取得
        return sharedPreferences.getString("GitHubToken", "") ?: "" // トークンを返す（存在しない場合は空文字）
    }
}
