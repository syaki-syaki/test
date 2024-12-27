package com.example.sasakitest.model

data class Issue(
    val id: Long, // Issueの一意の識別子
    val title: String,
    val body: String?
)
