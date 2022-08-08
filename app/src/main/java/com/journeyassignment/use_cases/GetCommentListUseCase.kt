package com.journeyassignment.use_cases

import com.journeyassignment.data.State
import com.journeyassignment.data.mappers.toLocalComments
import com.journeyassignment.data.repositories.CommentsRepository
import com.journeyassignment.db.entities.Comment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCommentListUseCase @Inject constructor(private val commentsRepository: CommentsRepository) {

    suspend fun getComments(postId: Long): Flow<State<List<Comment>>> {
        return flow {
            emit(State.Success(commentsRepository.getLocalComments(postId)))

            val response = commentsRepository.getRemoteComments(postId)
            if (response is State.Success) {
                commentsRepository.addLocalComments(response.data.toLocalComments())
                emit(State.Success(commentsRepository.getLocalComments(postId)))
            } else if (response is State.Error) {
                emit(State.Error(response.error))
            }
        }
    }
}