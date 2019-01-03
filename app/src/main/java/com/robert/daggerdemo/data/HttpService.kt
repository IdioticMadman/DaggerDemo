package com.robert.daggerdemo.data

import com.robert.daggerdemo.bean.MainBean
import com.robert.daggerdemo.bean.SecondBean

class HttpService {

    fun getMainList(): MutableList<MainBean> {
        return ArrayList<MainBean>().apply {
            add(MainBean(1))
            add(MainBean(2))
            add(MainBean(3))
            add(MainBean(4))
        }
    }

    fun getSecondeList(): MutableList<SecondBean> {
        return ArrayList<SecondBean>().apply {
            add(SecondBean(1))
            add(SecondBean(2))
            add(SecondBean(3))
            add(SecondBean(4))
        }
    }
}
