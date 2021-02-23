package com.kkh.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kkh.mynews.view.MainFragment
import com.kkh.mynews.view.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }
}