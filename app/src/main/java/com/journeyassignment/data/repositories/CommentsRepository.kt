package com.journeyassignment.data.repositories

import com.journeyassignment.data.State
import com.journeyassignment.db.entities.Comment
import com.journeyassignment.network.models.CommentsApiModelItem

interface CommentsRepository {

    suspend fun getLocalComments(postId : Long) : List<Comment>
    suspend fun getRemoteComments(postId : Long) : State<List<CommentsApiModelItem>>
    suspend fun addLocalComments(comments : List<Comment>)
}