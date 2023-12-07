package com.example.learnmvp.view.alluser

import com.example.learnmvp.data.local.entity.UserEntity

interface MainView {

    interface AllUserView {
        fun showListUser(users: List<UserEntity>)
        fun goToInsertPage()
    }

    interface Presenter {
        fun loadDataUser()
        fun goToInsertForm()
    }

}