package com.example.learnmvp.data.remote.apiservice

import com.example.learnmvp.data.remote.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("breeds/image/random")
    suspend fun getRandomDog() : Response<ApiResponse>
}