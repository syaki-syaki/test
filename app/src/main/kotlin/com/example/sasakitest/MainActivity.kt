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
    private lateinit var queryEditText: EditText
    private lateinit var starsEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.searchButton)
        queryEditText = findViewById(R.id.queryEditText)
        starsEditText = findViewById(R.id.starsEditText)

        searchButton.setOnClickListener {
            val query = queryEditText.text.toString()
            val stars = starsEditText.text.toString().toIntOrNull() ?: 0
            if (query.isNotEmpty()) {
                val intent = Intent(this, RepositoryListActivity::class.java)
                intent.putExtra("query", query)
                intent.putExtra("stars", stars)
                startActivity(intent)
            } else {
                Toast.makeText(this, "検索キーワードを入力してください", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
