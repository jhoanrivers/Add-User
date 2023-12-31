package com.example.learnmvp.view.alluser

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnmvp.data.local.dabase.UserDatabase
import com.example.learnmvp.data.local.entity.UserEntity
import com.example.learnmvp.data.local.repository.UserRepository
import com.example.learnmvp.data.local.repository.UserRepositoryImpl
import com.example.learnmvp.databinding.ActivityMainBinding
import com.example.learnmvp.view.formuser.FormUserActivity
import com.example.learnmvp.view.random.RandomImageActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView.AllUserView {


    lateinit var presenter: MainView.Presenter
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: MainAdapter

    @Inject
    lateinit var userRepository: UserRepository

    lateinit var result: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        bindPresenter()
    }


    private fun initView(){
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == 123) {
                println("yes, it return 123")
                presenter.loadDataUser()
            }
        }

        presenter = MainPresenter(this, userRepository)
        presenter.loadDataUser()
        userAdapter = MainAdapter(object: MainAdapter.MainListener{

        })
        presenter.loadDataUser()
    }


    private fun bindPresenter() {
        binding.btnChangeData.setOnClickListener {
            presenter.goToInsertForm()
        }
        binding.randomImage.setOnClickListener {
            startActivity(Intent(this, RandomImageActivity::class.java))
        }
    }

    override fun showListUser(users: List<UserEntity>) {
        binding.rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }

        userAdapter.updateUser(users)
    }

    override fun goToInsertPage() {
        val intent = Intent(this, FormUserActivity::class.java)
        result.launch(intent)
    }

}