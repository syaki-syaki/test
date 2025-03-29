package com.example.sasakitest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class TokenInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        val savedToken = sharedPreferences.getString("GitHubToken", null)
        val savedUsername = sharedPreferences.getString("GitHubUsername", null)

        if (!savedToken.isNullOrEmpty() && !savedUsername.isNullOrEmpty()) {
            Toast.makeText(this, "トークンとユーザー名が既に保存されています。", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_token_input)

        val saveButton = findViewById<Button>(R.id.saveTokenButton)
        val tokenEditText = findViewById<EditText>(R.id.tokenEditText)

        saveButton.setOnClickListener {
            val token = tokenEditText.text.toString().trim()

            if (token.isEmpty()) {
                Toast.makeText(this, "トークンを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // トークンを保存し、ユーザー名を取得する
            CoroutineScope(Dispatchers.IO).launch {
                val username = fetchUsernameFromToken(token)
                if (username != null) {
                    with(sharedPreferences.edit()) {
                        putString("GitHubToken", token)
                        putString("GitHubUsername", username)
                        apply()
                    }

                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@TokenInputActivity, "トークンとユーザー名が保存されました", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@TokenInputActivity, MainActivity::class.java))
                        finish()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@TokenInputActivity, "トークンが無効です。もう一度試してください。", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private suspend fun fetchUsernameFromToken(token: String): String? {
        return try {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "Bearer $token")
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                val json = JSONObject(responseBody ?: "")
                json.getString("login")
            } else {
                Log.e("TokenInputActivity", "Failed to fetch username. Response code: ${response.code}")
                null
            }
        } catch (e: Exception) {
            Log.e("TokenInputActivity", "Error fetching username: ${e.message}")
            null
        }
    }
}
