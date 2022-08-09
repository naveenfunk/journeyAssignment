package com.journeyassignment.di

import com.journeyassignment.data.repositories.CommentsRepository
import com.journeyassignment.data.repositories.PostsRepository
import com.journeyassignment.use_cases.GetCommentListUseCase
import com.journeyassignment.use_cases.GetPostListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetCommentsUseCase(commentsRepository: CommentsRepository) : GetCommentListUseCase {
        return GetCommentListUseCase(commentsRepository)
    }

    @Provides
    fun provideGetPostsUseCase(postsRepository: PostsRepository) : GetPostListUseCase {
        return GetPostListUseCase(postsRepository)
    }
}