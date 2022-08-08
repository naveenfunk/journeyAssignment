package com.journeyassignment.di

import com.journeyassignment.data.local.LocalDataSource
import com.journeyassignment.data.local.LocalDataSourceImpl
import com.journeyassignment.data.remote.RemoteDataSource
import com.journeyassignment.data.remote.RemoteDataSourceImpl
import com.journeyassignment.data.repositories.CommentsRepository
import com.journeyassignment.data.repositories.CommentsRepositoryImpl
import com.journeyassignment.data.repositories.PostsRepository
import com.journeyassignment.data.repositories.PostsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    abstract fun provideRemoteSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun providePostRepository(postsRepository: PostsRepositoryImpl): PostsRepository

    @Binds
    @Singleton
    abstract fun provideCommentRepository(commentsRepository: CommentsRepositoryImpl): CommentsRepository

}