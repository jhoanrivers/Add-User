package com.example.learnmvp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiResponse (

    @SerializedName("message")
    val message: String,

    @SerializedName("status")
    val success: String,

)