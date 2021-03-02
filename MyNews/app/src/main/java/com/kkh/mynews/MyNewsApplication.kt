package com.kkh.mynews

import android.app.Application
import android.content.Context
import android.util.Log


/**
Paging
    https://developer.android.com/topic/libraries/architecture/paging?hl=ko

DI(Dependency Injection)
    Dagger2
    https://black-jin0427.tistory.com/104
    https://cmcmcmcm.blog/2017/07/27/didependency-injection-%EC%99%80-dagger2/
    Module : 필요한 객체를 제공
    Component : 모듈에서 제공받은 객체를 조합하여 필요한 곳에 주입
    Inject : 주입 받음


Service
JobScheduler
Workmanager
Animation
Coroutine
Annotation Processor
https://www.charlezz.com/?p=1167
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