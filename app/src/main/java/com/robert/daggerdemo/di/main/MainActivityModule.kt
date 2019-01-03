package com.robert.daggerdemo.di.main

import android.content.Context
import com.robert.daggerdemo.bean.MainBean
import com.robert.daggerdemo.data.main.MainRepository
import com.robert.daggerdemo.data.main.impl.DbMainRepository
import com.robert.daggerdemo.data.main.impl.NetMainRepository
import com.robert.daggerdemo.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainActivityModule(val context: Context) {

    @Provides
    @ActivityScope
    @Named("activity")
    fun provideContext(): Context {
        return context
    }

    @Provides
    @ActivityScope
    @Named("net")
    fun provideNetMainRepository(repository: NetMainRepository): MainRepository {
        return repository
    }

    @Provides
    @ActivityScope
    @Named("db")
    fun provideDbMainRepository(repository: DbMainRepository): MainRepository {
        return repository
    }

    @Provides
    fun provideMainBean(): MainBean {
        return MainBean(1)
    }
}