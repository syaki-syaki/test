package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SharedPreferencesからトークンを取得
        val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE)
        val savedToken = sharedPreferences.getString("GitHubToken", null)
        Log.d("LaunchActivity", "Saved token: $savedToken")
        // トークンが存在する場合は MainActivity に遷移
        if (!savedToken.isNullOrEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            // トークンが存在しない場合は TokenInputActivity に遷移
            startActivity(Intent(this, TokenInputActivity::class.java))
        }

        // LaunchActivity 自体を終了
        finish()
    }
}
