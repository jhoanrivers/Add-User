package com.example.learnmvp.view.formuser

import com.example.learnmvp.data.local.entity.UserEntity

interface FormUser {



    interface UserView {

        fun showError()

        fun showLoading()

        fun successAddUser()

        fun failedAddUser()

    }



    interface UserPresenter {

        fun insertUser(user: UserEntity)

    }

}