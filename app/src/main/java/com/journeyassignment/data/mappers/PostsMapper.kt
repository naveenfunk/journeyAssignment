package com.journeyassignment.data.mappers

import com.journeyassignment.db.entities.Post
import com.journeyassignment.network.models.PostApiModelItem


fun PostApiModelItem.toLocalPost() = Post(
    id = this.id,
    title = this.title,
    description = this.body
)

fun List<PostApiModelItem>.toLocalPosts(): List<Post> {
    return map { apiPost ->
        apiPost.toLocalPost()
    }
}