package com.journeyassignment.data.local

import com.journeyassignment.db.entities.Comment
import com.journeyassignment.db.entities.Post

interface LocalDataSource {

    suspend fun getLocalPosts() : List<Post>

    suspend fun getLocalComments(): List<Comment>

    suspend fun addPostsToLocal(posts: List<Post>)

    suspend fun addCommentsToLocal(comments: List<Comment>)
}