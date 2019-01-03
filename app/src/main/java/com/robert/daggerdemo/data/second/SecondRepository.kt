package com.robert.daggerdemo.data.second

import com.robert.daggerdemo.bean.SecondBean

interface SecondRepository {
    fun getSecondList(): MutableList<SecondBean>
}