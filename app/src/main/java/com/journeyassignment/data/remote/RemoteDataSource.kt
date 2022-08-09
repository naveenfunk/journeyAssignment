package com.journeyassignment.data.remote

import com.journeyassignment.network.models.PostApiModelItem
import com.journeyassignment.data.State
import com.journeyassignment.network.models.CommentsApiModelItem

interface RemoteDataSource {

    suspend fun getPosts() : State<List<PostApiModelItem>>
    suspend fun getComments(postId : Long) : State<List<CommentsApiModelItem>>
}