package com.kkh.mynews

import android.app.Application
import android.content.Context
import android.util.Log


/**
[Android/Kotlin][MyNews]
https://developer.android.com/guide?hl=ko
Activity / Fragment / Intent
View / RecyclerView(Paging) / Window / Widget / Animation / Image / Databinding
Thread / Coroutine
Room / Cache
Rx / LiveData
DI / Dagger2 / Hilt
Service / BR / WorkManager /JobScheduler
Android SDK
Google IO
AAR / Testing / Mockito / UnitTest / CI



 */

// @HiltAndroidApp 어노테이션을 사용하여 컴파일 타임에 필요한 클래스들을 로
class MyNewsApplication : Application() {
    companion object {
        const val TAG = "[KKH]MyNewsApplication"
        private var instance: MyNewsApplication? = null
        fun getAppContext(): Context {
            return instance!!.applicationContext
        }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }
}