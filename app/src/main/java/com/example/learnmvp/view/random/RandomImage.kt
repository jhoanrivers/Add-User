package com.example.learnmvp.view.random

import com.example.learnmvp.data.remote.model.ApiResponse

interface RandomImage {


    interface RandomImageView {
        fun showImage(response: ApiResponse?)
        fun failedLoadImage()
        fun showLoading(b: Boolean)
    }


    interface Presenter {
        fun loadImage()
    }

}