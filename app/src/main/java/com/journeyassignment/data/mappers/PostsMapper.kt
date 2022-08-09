package com.journeyassignment.data.mappers

import com.journeyassignment.db.entities.Post
import com.journeyassignment.network.models.PostApiModelItem
import com.journeyassignment.ui.post_list.PostUiState


fun PostApiModelItem.toLocalPost() = Post(
    id = this.id,
    title = this.title,
    description = this.body
)

fun Post.toUiPost() = PostUiState(
    id = this.id,
    title = this.title ?: "",
    description = this.description ?: ""
)


fun List<PostApiModelItem>.toLocalPosts(): List<Post> {
    return map { apiPost ->
        apiPost.toLocalPost()
    }
}

fun List<Post>.toUiPosts(): List<PostUiState> {
    return map { localPost ->
        localPost.toUiPost()
    }
}