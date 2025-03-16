package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.IssueAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IssueListActivity : AppCompatActivity() { // Activity クラスを継承し、画面を作成する
    private lateinit var recyclerView: RecyclerView // RecyclerView のインスタンス（リストビュー）
    private lateinit var nextPageButton: Button // 次のページに進むボタン
    private lateinit var prevPageButton: Button // 前のページに戻るボタン
    private lateinit var createIssueButton: Button // 新しい Issue を作成するボタン
    private lateinit var editIssueLauncher: ActivityResultLauncher<Intent> // Issue 編集用の ActivityResultLauncher
    private lateinit var createIssueLauncher: ActivityResultLauncher<Intent> // Issue 作成用の ActivityResultLauncher

    private val issueAdapter = IssueAdapter(
        onEdit = { issue ->
            Log.d("IssueListActivity", "Edit button clicked for issue Number: ${issue.id}")
            val intent =
                Intent(this, EditIssueActivity::class.java) // EditIssueActivity に遷移する Intent
            intent.putExtra("issueNumber", issue.id) // Issue番号を渡す
            intent.putExtra("repositoryName", repositoryName) // リポジトリ名を渡す
            intent.putExtra("issueTitle", issue.title) // Issue のタイトルを渡す
            intent.putExtra("issueBody", issue.body) // Issue の本文を渡す
            editIssueLauncher.launch(intent) // EditIssueActivity を起動
        },
        onDelete = { issue ->
            Log.d("IssueListActivity", "Delete button clicked for issue Number: ${issue.id}")
            deleteIssue(issue.id) // deleteIssue() を実行し、Issue を削除
        }
    )


    private var currentPage = 1 // 現在のページ番号
    private var isLoading = false // API リクエストの進行中フラグ
    private var hasNextPage = true // 次のページがあるかどうかのフラグ
    private lateinit var repositoryName: String // リポジトリ名（後からセット）

    override fun onCreate(savedInstanceState: Bundle?) { // Activity の作成時に呼ばれる
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list) // activity_issue_list.xml をレイアウトとして適用

        // ActivityResultLauncher を初期化（Issue 編集）
        editIssueLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    Log.d("IssueListActivity", "Issue edited successfully.")
                    loadIssues(repositoryName) // 編集が成功した場合、Issue のリストを再取得
                } else {
                    Log.d("IssueListActivity", "Issue editing was canceled.")
                }
            }

        // ActivityResultLauncher を初期化（Issue 作成）
        createIssueButton.setOnClickListener { // 「Issue 作成」ボタンが押されたときの処理
            if (repositoryName.isNotEmpty()) { // リポジトリ名が空でないかチェック
                val intent = Intent(this, CreateIssueActivity::class.java) // CreateIssueActivity に画面遷移するための Intent を作成
                intent.putExtra("repositoryName", repositoryName) // Intent にリポジトリ名を追加（次の画面で使うため）
                createIssueLauncher.launch(intent) // CreateIssueActivity を開始（戻り値を受け取るため ActivityResultLauncher を使用）
            } else { // リポジトリ名が空だった場合
                Toast.makeText(this, "リポジトリ名が無効です", Toast.LENGTH_SHORT).show() // ユーザーにエラーメッセージを表示
            }
        }


        recyclerView = findViewById(R.id.recyclerView) // RecyclerView を XML から取得
        recyclerView.layoutManager = LinearLayoutManager(this) // 縦方向にリストを並べる
        recyclerView.adapter = issueAdapter // RecyclerView に Adapter をセット

        nextPageButton = findViewById(R.id.nextPageButton) // 次のページボタン
        prevPageButton = findViewById(R.id.prevPageButton) // 前のページボタン
        createIssueButton = findViewById(R.id.createIssueButton) // Issue 作成ボタン

        repositoryName = intent.getStringExtra("repositoryName") ?: "" // Intent からリポジトリ名を取得



        createIssueButton.setOnClickListener {
            if (repositoryName.isNotEmpty()) {
                val intent = Intent(this, CreateIssueActivity::class.java)
                intent.putExtra("repositoryName", repositoryName)
                createIssueLauncher.launch(intent)
            } else {
                Toast.makeText(this, "リポジトリ名が無効です", Toast.LENGTH_SHORT).show()
            }
        }

        nextPageButton.setOnClickListener { // 「次のページ」ボタンが押されたときの処理
            if (hasNextPage && !isLoading) { // 次のページが存在し、データの読み込み中でない場合
                currentPage++ // ページ番号を 1 つ増やす
                loadIssues(repositoryName) // loadIssues() を実行して、次のページの Issue を取得
            }
        }

        prevPageButton.setOnClickListener { // 「前のページ」ボタンが押されたときの処理
            if (currentPage > 1 && !isLoading) { // 現在のページが 1 より大きく、データの読み込み中でない場合
                currentPage-- // ページ番号を 1 つ減らす
                loadIssues(repositoryName) // loadIssues() を実行して、前のページの Issue を取得
            }
        }


        loadIssues(repositoryName) // Issue リストを取得
    }



    private fun loadIssues(repositoryName: String) {
        isLoading = true // ロード中のフラグを true にする（ボタン連打防止）
        nextPageButton.visibility = View.GONE // 次ページボタンを一時的に非表示
        prevPageButton.visibility = View.GONE // 前ページボタンを一時的に非表示

        CoroutineScope(Dispatchers.IO).launch { // IO スレッドで API を呼び出す（バックグラウンド処理）
            try {
                val issues = GitHubApiService.getIssues( // GitHub API から Issue を取得
                    this@IssueListActivity, // IssueListActivity の Context を渡す
                    repositoryName, // 指定されたリポジトリ名
                    currentPage.toString(),// 現在のページ番号
                    25 // 1ページあたりの Issue 件数
                )

                withContext(Dispatchers.Main) { // メインスレッドに戻して UI を更新
                    issueAdapter.submitList(issues) // 取得した Issue のリストを RecyclerView にセット
                    hasNextPage = issues.size == 25 // 取得した Issue 数が 25 件なら次ページあり

                    nextPageButton.visibility = if (hasNextPage) View.VISIBLE else View.GONE // 次ページボタンの表示を制御
                    prevPageButton.visibility = if (currentPage > 1) View.VISIBLE else View.GONE // 前ページボタンの表示を制御

                    if (issues.isEmpty()) { // Issue が 1 件も取得できなかった場合
                        Toast.makeText( // ユーザーに「Issue がない」ことを通知
                            this@IssueListActivity,
                            "イシューがありません。新規作成してください。",
                            Toast.LENGTH_SHORT
                        ).show()

                        issueAdapter.notifyDataSetChanged() // RecyclerView を更新（ボタンの無効化のため）
                    }
                    isLoading = false // データのロードが完了したためフラグを false に戻す
                }
            } catch (e: Exception) { // 例外処理（ネットワークエラーや API エラー）
                withContext(Dispatchers.Main) { // メインスレッドでエラーメッセージを表示
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
                isLoading = false // エラー発生時でもフラグを false に戻す
            }
        }
    }

    // Issue を削除する関数
    private fun deleteIssue(issueId: String) { // Issue ID（issue.id）を受け取る
        CoroutineScope(Dispatchers.IO).launch { // IO スレッドで非同期処理を実行
            try {
                Log.d("IssueListActivity", "Attempting to delete (close) issue with ID: $issueId") // デバッグログを出力

                // GitHub API にリクエストを送信して Issue を削除
                GitHubApiService.deleteIssue(this@IssueListActivity, issueId)

                withContext(Dispatchers.Main) { // UI 更新のためメインスレッドに戻る
                    issueAdapter.issueList.removeIf { it.id == issueId } // Issue ID に一致するデータをリストから削除
                    if (issueAdapter.issueList.isEmpty()) { // リストが空の場合
                        // 遷移元の Activity に戻る
                        when (intent.getStringExtra("fromActivity")) {
                            "RepositoryListActivity" -> startActivity(Intent(this@IssueListActivity, RepositoryListActivity::class.java))
                            "UserRepositoryListActivity" -> startActivity(Intent(this@IssueListActivity, UserRepositoryListActivity::class.java))
                            else -> Toast.makeText(this@IssueListActivity, "遷移元が不明です", Toast.LENGTH_SHORT).show()
                        }
                        finish() // 現在の Activity を終了
                    } else {
                        issueAdapter.notifyDataSetChanged() // RecyclerView を更新
                        Toast.makeText(this@IssueListActivity, "イシューを削除しました", Toast.LENGTH_SHORT).show() // 削除成功のメッセージを表示
                    }
                }
            } catch (e: Exception) { // 例外処理（削除 API のエラー）
                Log.e("IssueListActivity", "Failed to delete issue: ${e.message}") // エラーログを出力
                withContext(Dispatchers.Main) { // UI スレッドでエラーメッセージを表示
                    Toast.makeText(this@IssueListActivity, "削除に失敗しました: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}