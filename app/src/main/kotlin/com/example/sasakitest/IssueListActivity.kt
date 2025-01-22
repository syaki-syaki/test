package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.IssueAdapter
import com.example.sasakitest.model.Issue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IssueListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button
    private lateinit var createIssueButton: Button

    private val issueAdapter = IssueAdapter(
        onEdit = { issue ->
            // コメントの編集処理
            editComment(issue)
        },
        onDelete = { issue ->
            // コメントの削除処理
            deleteComment(issue)
        }
    )

    private var currentPage = 1
    private var isLoading = false
    private var hasNextPage = true
    private lateinit var repositoryName: String

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

        createIssueButton.setOnClickListener {
            if (repositoryName.isNotEmpty()) {
                val intent = Intent(this, CreateIssueActivity::class.java)
                intent.putExtra("repositoryName", repositoryName)
                startActivity(intent)
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
                val issues = GitHubApiService.getIssues(this@IssueListActivity, repositoryName, currentPage, 25)
                withContext(Dispatchers.Main) {
                    if (issues.isNotEmpty()) {
                        issueAdapter.submitList(issues)
                        hasNextPage = issues.size == 25
                        nextPageButton.visibility = if (hasNextPage) View.VISIBLE else View.GONE
                        prevPageButton.visibility = if (currentPage > 1) View.VISIBLE else View.GONE
                    } else {
                        hasNextPage = false
                        Toast.makeText(this@IssueListActivity, "データがありません", Toast.LENGTH_SHORT).show()
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

    private fun editComment(issue: Issue) {
        val newCommentBody = "編集後のコメント内容"
        CoroutineScope(Dispatchers.IO).launch {
            try {
                GitHubApiService.editComment(this@IssueListActivity, repositoryName, issue.id.toInt(), newCommentBody)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "コメントを編集しました", Toast.LENGTH_SHORT).show()
                    loadIssues(repositoryName)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun deleteComment(issue: Issue) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                GitHubApiService.deleteComment(this@IssueListActivity, repositoryName, issue.id.toInt())
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "コメントを削除しました", Toast.LENGTH_SHORT).show()
                    loadIssues(repositoryName)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
