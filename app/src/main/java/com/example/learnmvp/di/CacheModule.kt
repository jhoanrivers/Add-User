package com.example.learnmvp.di

import android.content.Context
import com.example.learnmvp.data.local.dabase.UserDatabase
import com.example.learnmvp.data.local.dao.UserDao
import com.example.learnmvp.data.local.repository.UserRepository
import com.example.learnmvp.data.local.repository.UserRepositoryImpl
import com.example.learnmvp.data.remote.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CacheModule {



    @Provides
    @Singleton
    fun provideUserDatabase (@ApplicationContext context: Context) : UserDatabase {
        return UserDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideDao(userDatabase: UserDatabase) : UserDao {
        return userDatabase.userDao()
    }


    @Provides
    @Singleton
    fun provideRepository(userDao: UserDao) : UserRepository {
        return UserRepositoryImpl(userDao)
    }

}