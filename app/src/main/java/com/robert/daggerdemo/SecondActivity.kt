package com.robert.daggerdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.robert.daggerdemo.data.HttpService
import com.robert.daggerdemo.data.main.MainRepository
import com.robert.daggerdemo.data.second.SecondRepository
import com.robert.daggerdemo.di.AppComponent
import com.robert.daggerdemo.di.main.DaggerMainActivityComponent
import com.robert.daggerdemo.di.main.MainActivityModule
import javax.inject.Inject
import javax.inject.Named

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SecondActivity"
    }

    @Inject
    lateinit var context: AppCompatActivity

    @field:[Inject Named("application")]
    lateinit var appContext: Context

    @Inject
    lateinit var repository: SecondRepository

    @Inject
    lateinit var httpService: HttpService

    override fun onCreate(savedInstanceState: Bundle?) {
        getAppComponent()
            .provideSecondComponent()
            .activity(this)
            .id(10)
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.e(TAG, "App Context: ${appContext}: ${this.applicationContext}")
        Log.e(TAG, "Activity Context: ${context}: ${this}")
        Log.e(TAG, "HttpService: ${httpService}: ")
        findViewById<View>(R.id.tv_show).setOnClickListener {
            val size = repository.getSecondList().size
            Toast.makeText(context, "size: $size", Toast.LENGTH_SHORT).show()
        }
    }

    fun getAppComponent(): AppComponent {
        return (application as App).appComponent
    }
}