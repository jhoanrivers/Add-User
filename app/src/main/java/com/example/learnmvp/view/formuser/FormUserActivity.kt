package com.example.learnmvp.view.formuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.Toast
import com.example.learnmvp.R
import com.example.learnmvp.data.local.dabase.UserDatabase
import com.example.learnmvp.data.local.dao.UserDao
import com.example.learnmvp.data.local.entity.UserEntity
import com.example.learnmvp.data.local.repository.UserRepository
import com.example.learnmvp.data.local.repository.UserRepositoryImpl
import com.example.learnmvp.databinding.ActivityFormUserBinding

class FormUserActivity : AppCompatActivity(), FormUser.UserView {

    lateinit var formUserPresenter: FormUserPresenter

    lateinit var binding: ActivityFormUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initFields()
        initPresenter()
    }


    private fun initView() {

        val userDao = UserDatabase.getDatabase(this).userDao()
        val repository: UserRepository = UserRepositoryImpl(userDao)
        formUserPresenter = FormUserPresenter(this, repository)


    }

    private fun initFields() {
        binding.btnInputUser.setOnClickListener {
            formUserPresenter.createUser(binding.name.text.toString(), binding.email.text.toString())
        }
    }

    private fun initPresenter() {



    }



    override fun showError() {

    }

    override fun showLoading() {

    }

    override fun successAddUser() {
        Toast.makeText(this, "Success Add User", Toast.LENGTH_SHORT).show()
        setResult(123)
        finish()

    }

    override fun failedAddUser() {
        Toast.makeText(this, "Failed Add User", Toast.LENGTH_SHORT).show()
    }
}