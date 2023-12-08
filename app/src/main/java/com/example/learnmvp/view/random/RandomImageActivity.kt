package com.example.learnmvp.view.random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.learnmvp.data.remote.model.ApiResponse
import com.example.learnmvp.data.remote.repository.RemoteRepository
import com.example.learnmvp.databinding.ActivityRandomImageBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RandomImageActivity : AppCompatActivity(), RandomImage.RandomImageView {

    lateinit var binding : ActivityRandomImageBinding
    lateinit var presenter: RandomImage.Presenter

    @Inject
    lateinit var remoteRepository: RemoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomImageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
    }

    private fun initView() {
        presenter = RandomImagePresenter(remoteRepository, this)
        presenter.loadImage()
    }

    override fun showImage(response: ApiResponse?) {

        Glide.with(this)
            .load(response?.message)
            .into(binding.imgRandom)

    }

    override fun failedLoadImage() {
        Toast.makeText(this, "Failed To Load Image", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(b: Boolean) {
        if(b){
            binding.pbItem.visibility = View.VISIBLE
        } else
            binding.pbItem.visibility = View.GONE
    }
}