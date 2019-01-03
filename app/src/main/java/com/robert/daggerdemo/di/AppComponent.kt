package com.robert.daggerdemo.di

import android.content.Context
import com.robert.daggerdemo.data.HttpService
import com.robert.daggerdemo.di.second.SecondComponent
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun provideHttpService(): HttpService

    @Named("application")
    fun provideContext(): Context

    fun provideSecondComponent(): SecondComponent.Builder
}