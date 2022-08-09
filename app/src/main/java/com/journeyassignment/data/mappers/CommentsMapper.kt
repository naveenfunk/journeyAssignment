package com.journeyassignment.data.mappers

import com.journeyassignment.db.entities.Comment
import com.journeyassignment.network.models.CommentsApiModelItem
import com.journeyassignment.ui.post_detail.CommentUiState

fun CommentsApiModelItem.toLocalComment() = Comment(
    id = this.id,
    postId = this.postId,
    name = this.name,
    email = this.email,
    commentText = this.body
)

fun Comment.toUiComment() = CommentUiState(
    id = this.id,
    name = this.name ?: "",
    email = this.email ?: "",
    description = this.commentText ?: ""
)

fun List<CommentsApiModelItem>.toLocalComments(): List<Comment> {
    return map { apiComment ->
        apiComment.toLocalComment()
    }
}

fun List<Comment>.toUiComments(): List<CommentUiState> {
    return map { localComment ->
        localComment.toUiComment()
    }
}