package com.example.learnmvp.data.local.dabase

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learnmvp.data.local.dao.UserDao
import com.example.learnmvp.data.local.entity.UserEntity


@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE : UserDatabase? = null


        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "my_app_database"
                ).build()

                INSTANCE = instance
                instance

            }
        }


    }
}