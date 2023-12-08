package com.example.learnmvp.view.random

import com.example.learnmvp.data.remote.repository.NetworkResult
import com.example.learnmvp.data.remote.repository.RemoteRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class RandomImagePresenter @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val view: RandomImage.RandomImageView
) : RandomImage.Presenter {


    override fun loadImage() {
        view.showLoading(true)
                CoroutineScope(Dispatchers.IO).launch {
                remoteRepository.getRandom().collect{ result ->
                    when(result){
                        is NetworkResult.ErrorResponse -> {
                            withContext(Dispatchers.Main){
                                view.showLoading(false)
                                view.failedLoadImage()
                            }
                        }
                        is NetworkResult.Success -> {
                            withContext(Dispatchers.Main){
                                view.showLoading(false)
                                view.showImage(result.data)
                            }

                        }
                    }

                }

            }
    }


}