// このファイルは、GitHubのイシュー（課題）の一覧を表示する画面を提供します。
// RecyclerViewを使ってイシューをリスト表示し、ページング処理を実装してスクロールで追加データを読み込みます。

package com.example.sasakitest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.sasakitest.adapter.IssueAdapter

// イシューリストを表示するアクティビティ
class IssueListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView // イシューを表示するリストビュー
    private val issueAdapter = IssueAdapter() // リストのデータを管理するアダプター

    private var currentPage = 1 // 現在のページ番号（初期値は1）
    private var isLoading = false // データをロード中かどうかを示すフラグ
    private var hasNextPage = true // 次のページがあるかどうかを示すフラグ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 親クラスの初期化
        setContentView(R.layout.activity_issue_list) // レイアウトファイルを設定

        // RecyclerViewを初期化
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // 縦方向にスクロールするレイアウト
        recyclerView.adapter = issueAdapter // アダプターをRecyclerViewにセット

        // リポジトリ名とトークンを取得
        val repositoryName = intent.getStringExtra("repositoryName") ?: "" // インテントからリポジトリ名を取得
        val token = getToken() // 保存されているトークンを取得

        // リポジトリ名またはトークンが無効な場合はエラーメッセージを表示して終了
        if (repositoryName.isEmpty() || token.isEmpty()) {
            Toast.makeText(this, "リポジトリ名またはトークンが無効です", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // 初回のデータロード
        loadIssues(repositoryName, token)

        // リストがスクロールされたときの処理を設定
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // リストが終端に近づいたときに次のページをロード
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount // 全体のアイテム数を取得
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition() // 最後に表示されたアイテムの位置を取得

                // ロード中でなく、次のページがあり、終端に近づいた場合にデータをロード
                if (!isLoading && hasNextPage && totalItemCount <= lastVisibleItem + 5) {
                    loadIssues(repositoryName, token)
                }
            }
        })
    }

    // イシューをロードするメソッド
    private fun loadIssues(repositoryName: String, token: String) {
        isLoading = true // ロード中フラグをセット

        // 非同期処理でデータを取得
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // GitHubApiServiceからイシューを取得
                val issues = GitHubApiService.getIssues(repositoryName, token, currentPage, 25)
                withContext(Dispatchers.Main) { // UIスレッドでリストを更新
                    issueAdapter.submitList(issueAdapter.currentList + issues) // 既存リストに新しいデータを追加
                    currentPage++ // ページ番号を次に進める
                    isLoading = false // ロード中フラグを解除
                    hasNextPage = issues.isNotEmpty() // データが空でない場合は次のページがある
                }
            } catch (e: Exception) { // エラー発生時の処理
                withContext(Dispatchers.Main) {
                    // エラーメッセージをトーストで表示
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
                isLoading = false // ロード中フラグを解除
            }
        }
    }

    // トークンを取得するメソッド
    private fun getToken(): String {
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE) // SharedPreferencesを取得
        return sharedPreferences.getString("GitHubToken", "") ?: "" // トークンを取得（存在しない場合は空文字を返す）
    }
}
