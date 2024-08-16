package com.greenrobot.wanderwise.android

import android.app.Application

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

//        initKoin {
//            androidLogger(Level.ERROR)
//            androidContext(this@Application)
//        }
    }
}