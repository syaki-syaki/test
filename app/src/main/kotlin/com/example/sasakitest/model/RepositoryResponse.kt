package com.example.sasakitest.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepositoryResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<Item>
) : Parcelable {
    @Parcelize
    data class Item(
        val id: Int,
        val name: String,
        val description: String?,
        @SerializedName("html_url") val htmlUrl: String,
        val owner: Owner // ここを追加
    ) : Parcelable

    @Parcelize
    data class Owner( // Ownerクラスを明示的に定義
        val login: String
    ) : Parcelable
}