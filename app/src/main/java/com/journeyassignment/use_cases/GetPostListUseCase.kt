package com.journeyassignment.use_cases

import com.journeyassignment.data.State
import com.journeyassignment.data.mappers.toLocalPosts
import com.journeyassignment.data.repositories.PostsRepository
import com.journeyassignment.db.entities.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(private val postsRepository: PostsRepository) {

    suspend fun getPosts(): Flow<State<List<Post>>> {
        return flow {
            emit(State.Success(postsRepository.getLocalPosts()))

            val response = postsRepository.getRemotePosts()
            if (response is State.Success) {
                postsRepository.addLocalPosts(response.data.toLocalPosts())
                emit(State.Success(postsRepository.getLocalPosts()))
            } else if (response is State.Error) {
                emit(State.Error(response.error))
            }
        }
    }

}