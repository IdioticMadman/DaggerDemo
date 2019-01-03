package com.robert.daggerdemo.di.main

import com.robert.daggerdemo.MainActivity
import com.robert.daggerdemo.di.AppComponent
import com.robert.daggerdemo.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}