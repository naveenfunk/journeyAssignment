package com.journeyassignment.di

import com.journeyassignment.misc.API_BASE_URL
import com.journeyassignment.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        val client = OkHttpClient.Builder().build()
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL).client(client)
            .addConverterFactory(getGsonConvertor())
            .build()
    }

    @Singleton
    @Provides
    fun createService(retrofit : Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    private fun getGsonConvertor(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}