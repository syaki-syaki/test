package com.example.sasakitest.model

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("total_count") val totalCount: Int, // 検索結果の総数
    @SerializedName("incomplete_results") val incompleteResults: Boolean, // 結果が完全ではないか
    @SerializedName("items") val items: List<Item> // リポジトリのリスト
) {
    data class Item(
        val id: Int, // リポジトリID
        val name: String, // リポジトリ名
        val description: String?, // 説明（null許容）
        @SerializedName("html_url") val htmlUrl: String // リポジトリのURL
    )
}
