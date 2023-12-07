package com.example.learnmvp

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LearnApplication : Application(), Application.ActivityLifecycleCallbacks{

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        println(" on activity crated")
    }

    override fun onActivityStarted(p0: Activity) {
        println("on activity started")
    }

    override fun onActivityResumed(p0: Activity) {
        println("on activityResumed")
    }

    override fun onActivityPaused(p0: Activity) {
        println("on activity paused")
    }

    override fun onActivityStopped(p0: Activity) {
        println("on activity stopped")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        println("on activity saveInstance")
    }

    override fun onActivityDestroyed(p0: Activity) {
        println("on activity destroyed")
    }


}