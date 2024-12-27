// このファイルはGitHub APIで使用する認証トークンを入力し、保存する画面の処理を提供します。
// 入力したトークンをSharedPreferencesに保存し、次の画面（MainActivity）に遷移します。

package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TokenInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 親クラスの初期化
        setContentView(R.layout.activity_token_input) // レイアウトを設定

        // Saveボタンを取得し、クリック時の処理を設定
        val saveButton = findViewById<Button>(R.id.saveTokenButton)
        saveButton.setOnClickListener {
            // 入力されたトークンを取得
            val token = findViewById<EditText>(R.id.tokenEditText).text.toString()

            // トークンが空の場合はエラーメッセージを表示
            if (token.isEmpty()) {
                Toast.makeText(this, "トークンを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // 処理を中断
            }

            // SharedPreferencesを使用してトークンを保存
            val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE) // SharedPreferencesを取得
            sharedPreferences.edit().putString("GitHubToken", token).apply() // トークンを保存して確定

            // 保存完了メッセージを表示
            Toast.makeText(this, "トークンが保存されました", Toast.LENGTH_SHORT).show()

            // メイン画面（MainActivity）に遷移
            val intent = Intent(this, MainActivity::class.java) // MainActivityを指定
            startActivity(intent) // 次の画面を開く
            finish() // 現在の画面を終了
        }
    }
}
