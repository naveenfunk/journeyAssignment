package com.journeyassignment.network.models

import com.google.gson.annotations.SerializedName

data class PostApiModelItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)