package com.journeyassignment.di

import com.journeyassignment.data.repositories.CommentsRepository
import com.journeyassignment.data.repositories.PostsRepository
import com.journeyassignment.use_cases.GetCommentListUseCase
import com.journeyassignment.use_cases.GetPostListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun provideGetCommentsUseCase(commentsRepository: CommentsRepository) : GetCommentListUseCase

    @Binds
    @Singleton
    abstract fun provideGetPostsUseCase(postsRepository: PostsRepository) : GetPostListUseCase
}