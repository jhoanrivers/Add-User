package com.example.learnmvp.data.remote.repository

import com.example.learnmvp.data.remote.model.ApiResponse

sealed class NetworkResult<out T> {


    class Success<out T>(val data : ApiResponse? = null) : NetworkResult<T>()


    class ErrorResponse(val message: String ?= null): NetworkResult<Nothing>()


}