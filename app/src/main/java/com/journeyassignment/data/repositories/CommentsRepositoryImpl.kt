package com.journeyassignment.data.repositories

import com.journeyassignment.data.State
import com.journeyassignment.data.local.LocalDataSource
import com.journeyassignment.data.remote.RemoteDataSource
import com.journeyassignment.db.entities.Comment
import com.journeyassignment.network.models.CommentsApiModelItem
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : CommentsRepository{

    override suspend fun getLocalComments(postId: Long): List<Comment> {
        return localDataSource.getLocalComments()
    }

    override suspend fun getRemoteComments(postId: Long): State<List<CommentsApiModelItem>> {
        return remoteDataSource.getComments()
    }

    override suspend fun addLocalComments(comments: List<Comment>) {
        localDataSource.addCommentsToLocal(comments)
    }
}