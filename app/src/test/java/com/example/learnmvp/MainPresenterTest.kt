package com.example.learnmvp

import com.example.learnmvp.data.local.dao.UserDao
import com.example.learnmvp.data.local.entity.UserEntity
import com.example.learnmvp.data.local.repository.UserRepository
import com.example.learnmvp.data.local.repository.UserRepositoryImpl
import com.example.learnmvp.data.remote.repository.RemoteRepository
import com.example.learnmvp.view.alluser.MainPresenter
import com.example.learnmvp.view.alluser.MainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {


    @Mock
    private lateinit var view : MainView.AllUserView

    private lateinit var presenter: MainPresenter

    lateinit var userDao: UserDao

    private lateinit var repository: UserRepositoryImpl


    @Before
    fun setup(){
        userDao = mock(UserDao::class.java)
        repository = UserRepositoryImpl(userDao)
        presenter = MainPresenter(view, repository)
    }

    @Test
    fun `Test Get User`()  = runTest {
        val listUser = listOf(UserEntity("jhoan", "jhoan@gmail.com"), UserEntity("herlina", "panjaitan"))
        `when`(
            userDao.getAllUsers()
        ).thenReturn(listUser)

        val result = repository.getUsers()


        assertEquals(listUser, result)

    }




}