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

class IssueListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button
    private lateinit var createIssueButton: Button
    private lateinit var editIssueLauncher: ActivityResultLauncher<Intent>
    private lateinit var createIssueLauncher: ActivityResultLauncher<Intent>//Intent二つあるしこの間数何
    private val issueAdapter = IssueAdapter(
        onEdit = { issue ->
            Log.d("IssueListActivity", "Edit button clicked for issue Number: ${issue.id}")
            val intent = Intent(this, EditIssueActivity::class.java)
            intent.putExtra("issueNumber", issue.id) // Issue番号を渡す
            intent.putExtra("repositoryName", repositoryName)
            intent.putExtra("issueTitle", issue.title)
            intent.putExtra("issueBody", issue.body)
            editIssueLauncher.launch(intent)
        },
        onDelete = { issue ->
            Log.d("IssueListActivity", "Delete button clicked for issue Number: ${issue.id}")
            deleteIssue(issue.id) // `issue.number`を渡す
        }
    )



    private var currentPage = 1
    private var isLoading = false
    private var hasNextPage = true
    private lateinit var repositoryName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list)//setContentViewとは

        // ActivityResultLauncher を初期化
        editIssueLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Log.d("IssueListActivity", "Issue edited successfully.")
                loadIssues(repositoryName) // イシューを再読み込み
            } else {
                Log.d("IssueListActivity", "Issue editing was canceled.")
            }
        }

        createIssueLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {// これもAppCompatActivityなの？
                Log.d("IssueListActivity", "Issue created successfully.")
                loadIssues(repositoryName) // イシューを再読み込み
            } else {
                Log.d("IssueListActivity", "Issue creation was canceled.")
            }
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)//このthisとlayoutManagerとadapterはなに
        recyclerView.adapter = issueAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)
        createIssueButton = findViewById(R.id.createIssueButton)

        repositoryName = intent.getStringExtra("repositoryName") ?: ""

        createIssueButton.setOnClickListener {
            if (repositoryName.isNotEmpty()) {
                val intent = Intent(this, CreateIssueActivity::class.java)
                intent.putExtra("repositoryName", repositoryName)
                createIssueLauncher.launch(intent)
            } else {
                Toast.makeText(this, "リポジトリ名が無効です", Toast.LENGTH_SHORT).show()
            }
        }

        nextPageButton.setOnClickListener {
            if (hasNextPage && !isLoading) {
                currentPage++
                loadIssues(repositoryName)
            }
        }

        prevPageButton.setOnClickListener {
            if (currentPage > 1 && !isLoading) {
                currentPage--
                loadIssues(repositoryName)
            }
        }

        loadIssues(repositoryName)
    }

    private fun loadIssues(repositoryName: String) {
        isLoading = true
        nextPageButton.visibility = View.GONE
        prevPageButton.visibility = View.GONE

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val issues = GitHubApiService.getIssues(
                    this@IssueListActivity,
                    repositoryName,
                    currentPage,
                    25
                )
                withContext(Dispatchers.Main) {
                    issueAdapter.submitList(issues)
                    hasNextPage = issues.size == 25
                    nextPageButton.visibility = if (hasNextPage) View.VISIBLE else View.GONE
                    prevPageButton.visibility = if (currentPage > 1) View.VISIBLE else View.GONE

                    if (issues.isEmpty()) {
                        Toast.makeText(
                            this@IssueListActivity,
                            "イシューがありません。新規作成してください。",
                            Toast.LENGTH_SHORT
                        ).show()

                        // 編集・削除ボタンを無効化
                        issueAdapter.notifyDataSetChanged()
                    }
                    isLoading = false
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
                isLoading = false
            }
        }
    }

    private fun deleteIssue(issueId: String) { // 修正: Int → String
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("IssueListActivity", "Attempting to delete (close) issue with ID: $issueId")

                // GitHub API にリクエストを送信
                GitHubApiService.deleteIssue(this@IssueListActivity, repositoryName, issueId)

                withContext(Dispatchers.Main) {
                    issueAdapter.issueList.removeIf { it.id == issueId } // 修正: `number` → `id`
                    if (issueAdapter.issueList.isEmpty()) {
                        // リストが空の場合、遷移元に戻る
                        when (intent.getStringExtra("fromActivity")) {
                            "RepositoryListActivity" -> startActivity(Intent(this@IssueListActivity, RepositoryListActivity::class.java))
                            "UserRepositoryListActivity" -> startActivity(Intent(this@IssueListActivity, UserRepositoryListActivity::class.java))
                            else -> Toast.makeText(this@IssueListActivity, "遷移元が不明です", Toast.LENGTH_SHORT).show()
                        }
                        finish() // 現在の画面を終了
                    } else {
                        // リストを更新
                        issueAdapter.notifyDataSetChanged()
                        Toast.makeText(this@IssueListActivity, "イシューを削除しました", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("IssueListActivity", "Failed to delete issue: ${e.message}")
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "削除に失敗しました: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
