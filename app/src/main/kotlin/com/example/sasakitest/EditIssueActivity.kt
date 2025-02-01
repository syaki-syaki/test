package com.example.sasakitest

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class EditIssueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_issue)

        val issueId = intent.getStringExtra("issueId") ?: "" // `issueNumber` → `issueId`
        val repositoryName = intent.getStringExtra("repositoryName") ?: ""
        val issueTitle = intent.getStringExtra("issueTitle") ?: ""
        val issueBody = intent.getStringExtra("issueBody") ?: ""

        val titleEditText: EditText = findViewById(R.id.titleEditText)
        val bodyEditText: EditText = findViewById(R.id.bodyEditText)
        val saveButton: Button = findViewById(R.id.saveButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)

        titleEditText.setText(issueTitle)
        bodyEditText.setText(issueBody)

        saveButton.setOnClickListener {
            val updatedTitle = titleEditText.text.toString()
            val updatedBody = bodyEditText.text.toString()

            if (updatedTitle.isBlank()) {
                Toast.makeText(this, "タイトルを入力してください", Toast.LENGTH_SHORT).show()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        GitHubApiService.editIssue(
                            context = this@EditIssueActivity,
                            repositoryName = repositoryName,
                            issueId = issueId, // `issueNumber` → `issueId`
                            title = updatedTitle,
                            body = updatedBody
                        )
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@EditIssueActivity, "イシューを編集しました", Toast.LENGTH_SHORT).show()
                            setResult(RESULT_OK)
                            finish()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@EditIssueActivity, "編集に失敗しました: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
