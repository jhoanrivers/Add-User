package com.example.learnmvp.data.local.repository

import com.example.learnmvp.data.local.dao.UserDao
import com.example.learnmvp.data.local.entity.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun getUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    override suspend fun insertUser(user: UserEntity) {
       return userDao.insertUser(user)
    }

    override suspend fun deleteUser(id: String) {
        return userDao.deleteUser(id)
    }
}