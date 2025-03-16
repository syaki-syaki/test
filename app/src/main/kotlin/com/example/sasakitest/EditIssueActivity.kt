package com.example.sasakitest

import android.app.Activity // `Activity.RESULT_CANCELED` などの定数を利用するためのクラス
import android.os.Bundle // `Activity` の状態管理を行うためのクラス
import android.widget.Button // `Button`（ボタン UI）を扱うためのクラス
import android.widget.EditText // `EditText`（入力フィールド UI）を扱うためのクラス
import android.widget.Toast // 短いメッセージをユーザーに表示するためのクラス
import androidx.appcompat.app.AppCompatActivity // Android の `Activity` の基本クラス
import kotlinx.coroutines.CoroutineScope // コルーチン（非同期処理の範囲）を管理するためのクラス
import kotlinx.coroutines.Dispatchers // `CoroutineScope` でどのスレッドを使うか指定するクラス
import kotlinx.coroutines.launch // 非同期処理を開始する関数
import kotlinx.coroutines.withContext // 別のスレッドに切り替える関数

class EditIssueActivity : AppCompatActivity() { // `Activity` クラスを継承し、Issue 編集画面を作成
    override fun onCreate(savedInstanceState: Bundle?) { // `Activity` の作成時に呼ばれる
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_issue) // `activity_edit_issue.xml` をレイアウトとして適用

        // `Intent` からデータを取得（渡された Issue の情報を取得する）
        val issueId = intent.getStringExtra("issueId") ?: "" // `Intent` から `issueId` を取得（空文字がデフォルト）
        val repositoryName = intent.getStringExtra("repositoryName") ?: "" // `Intent` からリポジトリ名を取得
        val issueTitle = intent.getStringExtra("issueTitle") ?: "" // `Intent` から Issue のタイトルを取得
        val issueBody = intent.getStringExtra("issueBody") ?: "" // `Intent` から Issue の本文を取得

        // 📝 `getStringExtra()` は `Intent` クラスのメソッドで、`putExtra()` で渡された文字列データを取得する関数
        // 📝 例: `intent.putExtra("key", "value")` → `intent.getStringExtra("key")` で `"value"` を取得できる

        // XML で定義された `EditText`（タイトル・本文の入力フィールド）と `Button` を取得
        val titleEditText: EditText = findViewById(R.id.titleEditText) // タイトル入力フィールド
        val bodyEditText: EditText = findViewById(R.id.bodyEditText) // 本文入力フィールド
        val saveButton: Button = findViewById(R.id.saveButton) // 保存ボタン
        val cancelButton: Button = findViewById(R.id.cancelButton) // キャンセルボタン

        // 取得した Issue のタイトルと本文を `EditText` にセット
        titleEditText.setText(issueTitle)
        bodyEditText.setText(issueBody)

        // 📝 `setText()` は `EditText` に文字列をセットする関数
        // 例: `editText.setText("Hello")` → `EditText` の入力欄に `"Hello"` が表示される

        saveButton.setOnClickListener { // 「保存」ボタンが押されたときの処理
            val updatedTitle = titleEditText.text.toString() // 入力されたタイトルを取得
            val updatedBody = bodyEditText.text.toString() // 入力された本文を取得

            if (updatedTitle.isBlank()) { // タイトルが空だった場合
                Toast.makeText(this, "タイトルを入力してください", Toast.LENGTH_SHORT).show() // ユーザーに警告メッセージを表示
            } else { // タイトルが入力されている場合
                CoroutineScope(Dispatchers.IO).launch { // `IO` スレッドで API を呼び出す（バックグラウンド処理）
                    try {
                        GitHubApiService.editIssue( // GitHub API にリクエストを送信し、Issue を編集
                            context = this@EditIssueActivity, // `Context`（画面情報）を渡す
                            issueId = issueId, // 編集対象の Issue ID
                            title = updatedTitle, // 新しいタイトル
                            body = updatedBody // 新しい本文
                        )
                        withContext(Dispatchers.Main) { // メインスレッドに戻して UI を更新
                            Toast.makeText(this@EditIssueActivity, "イシューを編集しました", Toast.LENGTH_SHORT).show() // 成功メッセージを表示
                            setResult(RESULT_OK) // `ActivityResult` の結果を `OK` に設定（前の画面に編集が成功したことを通知）
                            finish() // 画面を閉じて前の `Activity` に戻る
                        }
                    } catch (e: Exception) { // 例外処理（API 呼び出し時のエラー）
                        withContext(Dispatchers.Main) { // UI スレッドでエラーメッセージを表示
                            Toast.makeText(this@EditIssueActivity, "編集に失敗しました: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        cancelButton.setOnClickListener { // 「キャンセル」ボタンが押されたときの処理
            setResult(Activity.RESULT_CANCELED) // `ActivityResult` の結果を `CANCELED` に設定（前の画面に編集がキャンセルされたことを通知）
            finish() // 画面を閉じて前の `Activity` に戻る
        }
    }
}
