package com.journeyassignment.data.repositories

import com.journeyassignment.data.State
import com.journeyassignment.data.local.LocalDataSource
import com.journeyassignment.data.remote.RemoteDataSource
import com.journeyassignment.db.entities.Post
import com.journeyassignment.network.models.PostApiModelItem
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : PostsRepository{
    override suspend fun getLocalPosts(): List<Post> {
        return localDataSource.getLocalPosts()
    }

    override suspend fun getRemotePosts(): State<List<PostApiModelItem>> {
        return remoteDataSource.getPosts()
    }

    override suspend fun addLocalPosts(posts: List<Post>) {
        localDataSource.addPostsToLocal(posts)
    }
}