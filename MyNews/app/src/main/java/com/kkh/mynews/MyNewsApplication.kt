package com.kkh.mynews

import android.app.Application
import android.content.Context
import android.util.Log


/**
[Android/Kotlin]
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

[MyNews]
Intro Animation         ///////////////////[Doing]
    Progress
Main
SearchView
광고 + switch Animation
category panel
연관 List (가로)
list item
그리드 list
한정판 List (가로)
list item + count
scrolling + dynamic tab bar
SearchView
인기 검색어
최근 검색어
추천 검색어
검색어 추천


상품 dto common화 + 모듈화

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