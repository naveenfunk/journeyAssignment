package com.journeyassignment.network

import com.journeyassignment.network.models.CommentsApiModelItem
import com.journeyassignment.network.models.PostApiModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId : Long) : Response<List<CommentsApiModelItem>>

    @GET("posts")
    suspend fun getPosts() : Response<List<PostApiModelItem>>
}