package com.example.learnmvp.data.remote.repository

import com.example.learnmvp.data.remote.model.ApiResponse
import kotlinx.coroutines.flow.Flow


interface RemoteRepository{
    fun getRandom() : Flow<NetworkResult<ApiResponse>>
}