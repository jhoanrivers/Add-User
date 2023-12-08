package com.example.learnmvp.data.remote.repository

import android.view.KeyEvent.DispatcherState
import com.example.learnmvp.data.remote.apiservice.ApiService
import com.example.learnmvp.data.remote.model.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private  val apiService: ApiService) : RemoteRepository {


    override fun getRandom(): Flow<NetworkResult<ApiResponse>> {
        return flow {
            try {
                val response = apiService.getRandomDog()
                if(response.isSuccessful) {
                    emit(NetworkResult.Success<ApiResponse>(response.body()))
                } else{
                    emit(NetworkResult.ErrorResponse("Failed get Image"))
                }
            }catch (e: java.lang.Exception){
                throw e
            }
        }.catch { e ->
            emit(NetworkResult.ErrorResponse(e.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }




}