package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 検索クエリ入力用のEditTextを取得
        val searchBox = findViewById<EditText>(R.id.searchBox)
        // 検索ボタンを取得
        val searchButton = findViewById<Button>(R.id.searchButton)

        searchButton.setOnClickListener {
            val query = searchBox.text.toString().trim()

            if (query.isEmpty()) {
                Toast.makeText(this, "検索クエリを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // RepositoryListActivity に遷移
            val intent = Intent(this, RepositoryListActivity::class.java)
            intent.putExtra("query", query)
            startActivity(intent)
        }
    }
}


