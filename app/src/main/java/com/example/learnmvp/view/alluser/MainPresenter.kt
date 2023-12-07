package com.example.learnmvp.view.alluser

import com.example.learnmvp.data.local.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter( private val allUserView: MainView.AllUserView, private val userRepository: UserRepository) : MainView.Presenter {


    override fun loadDataUser() {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data  = userRepository.getUsers()

                withContext(Dispatchers.Main) {
                    allUserView.showListUser(data)
                }
            } catch (e: java.lang.Exception) {
              e.printStackTrace()
            }
        }
    }

    override fun goToInsertForm() {
        allUserView.goToInsertPage()
    }



}