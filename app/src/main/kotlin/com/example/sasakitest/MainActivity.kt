package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    // UI要素
    private lateinit var searchButton: Button
    private lateinit var userRepositoryButton: Button
    private lateinit var repositoryNameEditText: EditText
    private lateinit var keywordEditText: EditText
    private lateinit var starsEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.searchButton)
        userRepositoryButton = findViewById(R.id.userRepositoryButton)
        repositoryNameEditText = findViewById(R.id.repositoryNameEditText)
        keywordEditText = findViewById(R.id.keywordEditText)
        starsEditText = findViewById(R.id.starsEditText)

        // GitHub全体検索
        searchButton.setOnClickListener {
            val repositoryName = repositoryNameEditText.text.toString().ifEmpty { "" }
            val keyword = keywordEditText.text.toString().ifEmpty { "" }
            val stars = starsEditText.text.toString().toIntOrNull() ?: 0

            val intent = Intent(this, RepositoryListActivity::class.java)
            intent.putExtra("repositoryName", repositoryName)
            intent.putExtra("keyword", keyword)
            intent.putExtra("stars", stars)
            startActivity(intent)
        }

        // ユーザーリポジトリ内検索
        userRepositoryButton.setOnClickListener {
            val repositoryName = repositoryNameEditText.text.toString().ifEmpty { "" }
            val keyword = keywordEditText.text.toString().ifEmpty { "" }

            val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE)
            val token = sharedPreferences.getString("GitHubToken", "")

            if (token.isNullOrEmpty()) {
                Toast.makeText(this, "トークンが設定されていません。", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, UserRepositoryListActivity::class.java)
            intent.putExtra("repositoryName", repositoryName)
            intent.putExtra("keyword", keyword)
            startActivity(intent)
        }
    }
}