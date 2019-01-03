package com.robert.daggerdemo

import android.app.Application
import com.robert.daggerdemo.di.AppComponent
import com.robert.daggerdemo.di.AppModule
import com.robert.daggerdemo.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}