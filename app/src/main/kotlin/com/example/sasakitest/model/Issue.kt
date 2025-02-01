package com.example.sasakitest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Issue(
    val id: String,
    val title: String,
    val body: String?
) : Parcelable
