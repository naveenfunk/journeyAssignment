package com.journeyassignment.di

import android.content.Context
import androidx.room.Room
import com.journeyassignment.BuildConfig
import com.journeyassignment.db.AppDB
import com.journeyassignment.db.AppDao
import com.journeyassignment.network.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * All instances which needs application context or scope
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDB {
        return Room.databaseBuilder(
            context,
            AppDB::class.java,
            BuildConfig.APPLICATION_ID
        ).build()
    }

    @Singleton
    @Provides
    fun provideDBDao(db: AppDB) : AppDao = db.appDao()

    @Singleton
    @Provides
    fun provideNetworkMonitor(@ApplicationContext context: Context): NetworkMonitor {
        return NetworkMonitor(context)
    }

}