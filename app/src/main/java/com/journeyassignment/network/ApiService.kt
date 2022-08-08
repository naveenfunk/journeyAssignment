package com.journeyassignment.network

import com.journeyassignment.network.models.CommentsApiModelItem
import com.journeyassignment.network.models.PostApiModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("comments")
    suspend fun getComments() : Response<List<CommentsApiModelItem>>

    @GET("posts")
    suspend fun getPosts() : Response<List<PostApiModelItem>>
}