package com.robert.daggerdemo.data.main

import com.robert.daggerdemo.bean.MainBean
import javax.inject.Inject

interface MainRepository {
    fun getMainList(): MutableList<MainBean>
}