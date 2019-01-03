package com.robert.daggerdemo.di

import android.content.Context
import com.robert.daggerdemo.data.HttpService
import com.robert.daggerdemo.di.second.SecondComponent
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named
import javax.inject.Singleton

@Module(subcomponents = [SecondComponent::class])
class AppModule constructor(val context: Context) {

    @Provides
    @Singleton
    @Named("application")
    fun providerContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun providerHttpService(): HttpService {
        return HttpService()
    }
}