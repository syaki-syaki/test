package com.example.sasakitest.model

data class Comment(

    val id: Int, // コメントのID
    val body: String, // コメント本文
    val user: User // コメント作成者情報
)

data class User(
    val login: String // ユーザーのGitHubログイン名
)









