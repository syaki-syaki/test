package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TokenInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // トークンの存在をチェック
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE)
        val savedToken = sharedPreferences.getString("GitHubToken", null)

        if (!savedToken.isNullOrEmpty()) {
            // トークンが存在する場合、確認メッセージを表示
            Toast.makeText(this, "トークンが既に保存されています。", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        // トークンが存在しない場合のみ入力画面を表示
        setContentView(R.layout.activity_token_input)

        val saveButton = findViewById<Button>(R.id.saveTokenButton)
        saveButton.setOnClickListener {
            val token = findViewById<EditText>(R.id.tokenEditText).text.toString().trim()

            if (token.isEmpty()) {
                Toast.makeText(this, "トークンを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sharedPreferences.edit().putString("GitHubToken", token).apply()
            Toast.makeText(this, "トークンが保存されました", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}





