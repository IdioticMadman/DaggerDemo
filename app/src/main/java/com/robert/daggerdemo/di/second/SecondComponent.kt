package com.robert.daggerdemo.di.second

import android.support.v7.app.AppCompatActivity
import com.robert.daggerdemo.SecondActivity
import com.robert.daggerdemo.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [SecondModule::class])
interface SecondComponent {

    fun inject(activity: SecondActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        @BindsInstance
        fun id(id: Int): Builder

        fun build(): SecondComponent
    }
}