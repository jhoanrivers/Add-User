package com.example.learnmvp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.learnmvp.view.alluser.MainActivity
import com.example.learnmvp.view.random.RandomImageActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {



    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun testGotoRandomPage() {


        onView(withId(R.id.randomImage)).perform(click())


       onView(withId(R.id.randomImageLayout)).check(matches(isDisplayed()))

    }


}