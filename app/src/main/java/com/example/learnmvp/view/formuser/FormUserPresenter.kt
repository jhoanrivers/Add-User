package com.example.learnmvp.view.formuser

import com.example.learnmvp.data.local.entity.UserEntity
import com.example.learnmvp.data.local.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormUserPresenter(
    private val view: FormUser.UserView,
    private val repository: UserRepository
) : FormUser.UserPresenter {


    override fun insertUser(user: UserEntity) {

        CoroutineScope(Dispatchers.IO)
            .launch {
                try {
                    repository.insertUser(user)
                    withContext(Dispatchers.Main) {
                        view.successAddUser()
                    }
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    withContext(Dispatchers.Main) {
                        view.failedAddUser()
                    }
                }

            }

    }

    fun createUser(name: String, email: String) {
        val user = UserEntity(name, email)

        CoroutineScope(Dispatchers.IO)
            .launch {
                try {
                    repository.insertUser(user)
                    withContext(Dispatchers.Main) {
                        view.successAddUser()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    view.failedAddUser()
                }
            }
    }

}