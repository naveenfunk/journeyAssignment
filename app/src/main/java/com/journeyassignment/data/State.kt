package com.journeyassignment.data

sealed class State<out T>{

    data class Success<T>(val data: T) : State<T>()
    data class Error(val error: Int) : State<Nothing>()
    object Loading : State<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            Loading -> "Loading"
        }
    }
}
