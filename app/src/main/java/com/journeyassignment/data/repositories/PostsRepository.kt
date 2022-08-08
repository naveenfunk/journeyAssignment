package com.journeyassignment.data.repositories

import com.journeyassignment.data.State
import com.journeyassignment.db.entities.Post
import com.journeyassignment.network.models.PostApiModelItem

interface PostsRepository {

    suspend fun getLocalPosts() : List<Post>
    suspend fun getRemotePosts() : State<List<PostApiModelItem>>
    suspend fun addLocalPosts(posts : List<Post>)
}