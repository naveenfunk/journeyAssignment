@file:Suppress("UNCHECKED_CAST")

package com.journeyassignment.data.remote

import com.journeyassignment.network.ApiService
import com.journeyassignment.network.models.PostApiModelItem
import com.journeyassignment.data.State
import com.journeyassignment.misc.NETWORK_ERROR
import com.journeyassignment.misc.NO_NETWORK_AVAILABLE
import com.journeyassignment.network.NetworkMonitor
import com.journeyassignment.network.models.CommentsApiModelItem
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService, private val networkMonitor: NetworkMonitor) : RemoteDataSource{

    override suspend fun getPosts(): State<List<PostApiModelItem>> {
        val response = executeCall(apiService::getPosts)
        return response as State<List<PostApiModelItem>>
    }

    override suspend fun getComments(): State<List<CommentsApiModelItem>> {
        val response = executeCall(apiService::getPosts)
        return response as State<List<CommentsApiModelItem>>
    }

    private suspend fun executeCall(apiRequest : suspend () -> Response<*>) : State<*>{
        if (networkMonitor.networkAvailable){
            return State.Error(NO_NETWORK_AVAILABLE)
        }
        return try {
            val response = apiRequest.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                State.Success(response.body())
            } else {
                State.Error(responseCode)
            }
        } catch (e: IOException) {
            State.Error(NETWORK_ERROR)
        }
    }
}