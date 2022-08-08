package com.journeyassignment.network.models

import com.google.gson.annotations.SerializedName

data class CommentsApiModelItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("postId")
    val postId: Long
)