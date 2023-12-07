package com.example.learnmvp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.learnmvp.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getAllUsers() : List<UserEntity>


    @Insert
    suspend fun  insertUser(user: UserEntity)


    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteUser(userId: String)


}