package com.robert.daggerdemo.data.main.impl

import android.util.Log
import com.robert.daggerdemo.bean.MainBean
import com.robert.daggerdemo.data.HttpService
import com.robert.daggerdemo.data.main.MainRepository
import javax.inject.Inject

class DbMainRepository @Inject constructor(
    val httpService: HttpService
) : MainRepository {
    companion object {
        const val TAG = "NetMainRepository"
    }

    override fun getMainList(): MutableList<MainBean> {
        Log.e(TAG, "HttpService: ${httpService}")
        return httpService.getMainList()
    }
}