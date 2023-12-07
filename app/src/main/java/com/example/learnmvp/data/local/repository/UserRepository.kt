package com.example.learnmvp.data.local.repository

import com.example.learnmvp.data.local.dao.UserDao
import com.example.learnmvp.data.local.entity.UserEntity

interface UserRepository {

    suspend fun getUsers() : List<UserEntity>

    suspend fun insertUser(user: UserEntity)

    suspend fun deleteUser(id: String)

}