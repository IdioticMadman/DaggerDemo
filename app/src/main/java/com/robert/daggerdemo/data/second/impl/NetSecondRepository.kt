package com.robert.daggerdemo.data.second.impl

import android.util.Log
import com.robert.daggerdemo.bean.SecondBean
import com.robert.daggerdemo.data.HttpService
import com.robert.daggerdemo.data.main.impl.NetMainRepository
import com.robert.daggerdemo.data.second.SecondRepository
import javax.inject.Inject

class NetSecondRepository @Inject constructor(
    val httpService: HttpService
) : SecondRepository {
    companion object {
        const val TAG = "NetSecondRepository"
    }

    override fun getSecondList(): MutableList<SecondBean> {
        Log.e(TAG, "HttpService: ${httpService}")
        return httpService.getSecondeList()
    }
}