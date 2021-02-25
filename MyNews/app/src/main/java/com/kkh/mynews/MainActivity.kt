package com.kkh.mynews

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kkh.mynews.view.MainFragment
import com.kkh.mynews.view.NewsFragment
import com.kkh.mynews.view.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*

    MainActivity / Fragment - NewsViewModel
    NewsViewModel(LiveData) - NewsRepository
    NewsRepository - Model(Room)
    NewsRepository - Remote Data Source(Retrofit)

    [02/25+]
    UI
        Tab Fragment + RecyclerView + Paging
        Animation

    [02/28_일]
    DI(Hilt, Dagger2)
    네트워크 작업 + 코루틴
    Room
    [03/01_월]
    MVP 패턴
    Service
    Mockito
    Workmanager
    JobScheduler
    [03/02_수]
    Rx
    [03/03]
    DesignPattern목
    [03/04_목]
    CleanCode
    [03/05_금]
    Testing
        Mockitto + CI +UIAutomator + UnitTest
    [03/06_토]
    Performance
        Memory
    [03/07_일]
    Open Liberary


 */


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NewsFragment.newInstance())
                .commitNow()
        }
    }
}