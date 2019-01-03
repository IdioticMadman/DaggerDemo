package com.robert.daggerdemo.di.second

import com.robert.daggerdemo.data.second.SecondRepository
import com.robert.daggerdemo.data.second.impl.NetSecondRepository
import com.robert.daggerdemo.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class SecondModule {

    @Provides
    @ActivityScope
    fun provideSecondRepository(id: Int, repository: NetSecondRepository): SecondRepository {
        return repository
    }
}