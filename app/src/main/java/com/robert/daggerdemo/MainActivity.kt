package com.robert.daggerdemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.robert.daggerdemo.bean.MainBean
import com.robert.daggerdemo.data.HttpService
import com.robert.daggerdemo.data.main.MainRepository
import com.robert.daggerdemo.di.AppComponent
import com.robert.daggerdemo.di.main.DaggerMainActivityComponent
import com.robert.daggerdemo.di.main.MainActivityModule
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    @field:[Inject Named("activity")]
    lateinit var context1: Context

    @field:[Inject Named("activity")]
    lateinit var context2: Context

    @field:[Inject Named("application")]
    lateinit var appContext: Context

    @field:[Inject Named("net")]
    lateinit var repository1: MainRepository
    @field:[Inject Named("db")]
    lateinit var repository2: MainRepository

    @Inject
    lateinit var httpService: HttpService

    @Inject
    lateinit var mainBean1: MainBean

    @Inject
    lateinit var mainBean2: MainBean

    override fun onCreate(savedInstanceState: Bundle?) {
        val component = DaggerMainActivityComponent
            .builder()
            .appComponent(getAppComponent())
            .mainActivityModule(MainActivityModule(this))
            .build()
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "App Context: ${appContext}: ${this.applicationContext}")
        Log.e(TAG, "Activity Context: ${context1}: ${context2}")
        Log.e(TAG, "repository: ${repository1.hashCode()}: ${repository2.hashCode()}")
        Log.e(TAG, "mainBean: ${mainBean1.hashCode()}: ${mainBean2.hashCode()}")
        Log.e(TAG, "HttpService: ${httpService}: ")
        findViewById<View>(R.id.tv_show).setOnClickListener {
            val size = repository1.getMainList().size
            Toast.makeText(context1, "size: $size", Toast.LENGTH_SHORT).show()
        }
        findViewById<View>(R.id.btn_go).setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
    }

    fun getAppComponent(): AppComponent {
        return (application as App).appComponent
    }
}
