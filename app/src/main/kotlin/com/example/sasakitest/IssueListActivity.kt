package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    private lateinit var createIssueLauncher: ActivityResultLauncher<Intent>
    private val issueAdapter = IssueAdapter(
        onEdit = { issue ->
            val intent = Intent(this, EditIssueActivity::class.java)
            intent.putExtra("issueId", issue.id)
            intent.putExtra("repositoryName", repositoryName)
            intent.putExtra("username", username)
            editIssueLauncher.launch(intent)
        },
        onDelete = { issue ->
            deleteIssue(issue.id)
        }
    )

    private var currentPage = 1
    private var hasNextPage = true
    private var isLoading = false
    private lateinit var repositoryName: String
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = issueAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)
        createIssueButton = findViewById(R.id.createIssueButton)

        repositoryName = intent.getStringExtra("repositoryName") ?: ""
        username = intent.getStringExtra("username") ?: ""

        if (repositoryName.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "リポジトリ名またはユーザー名が取得できません", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        Log.d("IssueListActivity", "Received Data: repositoryName=$repositoryName, username=$username")

        editIssueLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                loadIssues()
            }
        }

        createIssueLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                loadIssues()
            }
        }

        createIssueButton.setOnClickListener {
            val intent = Intent(this, CreateIssueActivity::class.java)
            intent.putExtra("repositoryName", repositoryName)
            intent.putExtra("username", username)
            createIssueLauncher.launch(intent)
        }

        nextPageButton.setOnClickListener {
            if (hasNextPage && !isLoading) {
                currentPage++
                loadIssues()
            }
        }

        prevPageButton.setOnClickListener {
            if (currentPage > 1 && !isLoading) {
                currentPage--
                loadIssues()
            }
        }

        loadIssues()
    }

    private fun loadIssues() {
        isLoading = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val issues = GitHubApiService.getIssues(
                    context = this@IssueListActivity,
                    username = username,
                    repositoryName = repositoryName,
                    first = 25, // 25 件ごとに取得
                    after = if (currentPage > 1) "cursor_for_page_$currentPage" else null
                )

                withContext(Dispatchers.Main) {
                    issueAdapter.submitList(issues)
                    hasNextPage = issues.size == 25
                    isLoading = false

                    // ページングボタンの表示制御
                    prevPageButton.visibility = if (currentPage > 1) Button.VISIBLE else Button.GONE
                    nextPageButton.visibility = if (hasNextPage) Button.VISIBLE else Button.GONE

                    if (issues.isEmpty()) {
                        Toast.makeText(this@IssueListActivity, "イシューがありません。新規作成してください。", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                    isLoading = false
                }
            }
        }
    }

    private fun deleteIssue(issueId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                GitHubApiService.deleteIssue(this@IssueListActivity, issueId)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "イシューを削除しました", Toast.LENGTH_SHORT).show()
                    loadIssues()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "削除に失敗しました: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
