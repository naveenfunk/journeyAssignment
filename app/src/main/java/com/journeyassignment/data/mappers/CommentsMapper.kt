package com.journeyassignment.data.mappers

import com.journeyassignment.db.entities.Comment
import com.journeyassignment.network.models.CommentsApiModelItem

fun CommentsApiModelItem.toLocalComment() = Comment(
    id = this.id,
    postId = this.postId,
    title = this.name,
    description = this.body
)

fun List<CommentsApiModelItem>.toLocalComments(): List<Comment> {
    return map { apiComment ->
        apiComment.toLocalComment()
    }
}