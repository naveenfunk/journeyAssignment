package com.journeyassignment.data.local

import com.journeyassignment.db.AppDao
import com.journeyassignment.db.entities.Comment
import com.journeyassignment.db.entities.Post
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val appDao: AppDao) : LocalDataSource {

    override suspend fun getLocalPosts(): List<Post> {
        return appDao.getPosts()
    }

    override suspend fun getLocalComments(postId : Long): List<Comment> {
        return appDao.getComments(postId)
    }

    override suspend fun addPostsToLocal(posts: List<Post>) {
        appDao.addPosts(posts)
    }

    override suspend fun addCommentsToLocal(comments: List<Comment>) {
        appDao.addComments(comments)
    }
}