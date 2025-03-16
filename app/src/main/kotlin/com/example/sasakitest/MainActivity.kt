package com.example.sasakitest

import android.content.Intent // 別の `Activity` に画面遷移するためのクラス
import android.os.Bundle // `Activity` の状態を管理するためのクラス
import android.widget.Button // `Button`（ボタン UI）を扱うためのクラス
import android.widget.EditText // `EditText`（入力フィールド UI）を扱うためのクラス
import android.widget.Toast // 短いメッセージをユーザーに表示するためのクラス
import androidx.appcompat.app.AppCompatActivity // Android の `Activity` の基本クラス

class MainActivity : AppCompatActivity() { // `Activity` クラスを継承し、メイン画面を作成

    // UI要素を定義（`lateinit` を使って後で初期化）
    private lateinit var searchButton: Button // GitHub全体検索ボタン
    private lateinit var userRepositoryButton: Button // ユーザーリポジトリ内検索ボタン
    private lateinit var repositoryNameEditText: EditText // リポジトリ名の入力フィールド
    private lateinit var keywordEditText: EditText // キーワードの入力フィールド
    private lateinit var starsEditText: EditText // スター数の入力フィールド

    override fun onCreate(savedInstanceState: Bundle?) { // `Activity` の作成時に呼ばれる
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // `activity_main.xml` をレイアウトとして適用

        // 📝 `findViewById()` を使って XML で定義された UI 要素を取得
        searchButton = findViewById(R.id.searchButton) // GitHub全体検索ボタン
        userRepositoryButton = findViewById(R.id.userRepositoryButton) // ユーザーリポジトリ内検索ボタン
        repositoryNameEditText = findViewById(R.id.repositoryNameEditText) // リポジトリ名の入力欄
        keywordEditText = findViewById(R.id.keywordEditText) // キーワードの入力欄
        starsEditText = findViewById(R.id.starsEditText) // スター数の入力欄

        // GitHub全体検索ボタンが押されたときの処理
        searchButton.setOnClickListener {
            val repositoryName = repositoryNameEditText.text.toString().ifEmpty { "" } // 入力されたリポジトリ名を取得（空なら `""`）
            val keyword = keywordEditText.text.toString().ifEmpty { "" } // 入力されたキーワードを取得（空なら `""`）
            val stars = starsEditText.text.toString().toIntOrNull() ?: 0 // スター数を取得（数値変換できなければ 0）

            // 📝 `ifEmpty { "" }` は、文字列が空だった場合に `""`（空文字）を返す
            // 📝 `toIntOrNull()` は、数値に変換できない場合に `null` を返すため `?: 0` でデフォルト値を設定

            val intent = Intent(this, RepositoryListActivity::class.java) // `RepositoryListActivity` に画面遷移する `Intent`
            intent.putExtra("repositoryName", repositoryName) // `Intent` にリポジトリ名を追加
            intent.putExtra("keyword", keyword) // `Intent` にキーワードを追加
            intent.putExtra("stars", stars) // `Intent` にスター数を追加
            startActivity(intent) // `RepositoryListActivity` を開始
        }

        // ユーザーリポジトリ内検索ボタンが押されたときの処理
        userRepositoryButton.setOnClickListener {
            val repositoryName = repositoryNameEditText.text.toString().ifEmpty { "" } // 入力されたリポジトリ名を取得（空なら `""`）
            val keyword = keywordEditText.text.toString().ifEmpty { "" } // 入力されたキーワードを取得（空なら `""`）

            // `SharedPreferences` から GitHub のトークンを取得
            val sharedPreferences = getSharedPreferences("GitHubPrefs", MODE_PRIVATE) // `GitHubPrefs` という名前の `SharedPreferences` を取得
            val token = sharedPreferences.getString("GitHubToken", "") // `GitHubToken` を取得（デフォルトは `""`）

            // トークンが設定されていない場合、エラーメッセージを表示して処理を終了
            if (token.isNullOrEmpty()) { // `token` が `null` または 空文字の場合
                Toast.makeText(this, "トークンが設定されていません。", Toast.LENGTH_SHORT).show() // トークンがないことをユーザーに通知
                return@setOnClickListener // 処理を終了
            }

            val intent = Intent(this, UserRepositoryListActivity::class.java) // `UserRepositoryListActivity` に画面遷移する `Intent`
            intent.putExtra("repositoryName", repositoryName) // `Intent` にリポジトリ名を追加
            intent.putExtra("keyword", keyword) // `Intent` にキーワードを追加
            startActivity(intent) // `UserRepositoryListActivity` を開始
        }
    }
}
