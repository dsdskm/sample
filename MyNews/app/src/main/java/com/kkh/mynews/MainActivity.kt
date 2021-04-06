package com.kkh.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.kkh.mynews.common.Constant
import com.kkh.mynews.view.fragment.IntroFragment
import dagger.hilt.android.AndroidEntryPoint

/*

    MainActivity / Fragment - NewsViewModel
    NewsViewModel(LiveData) - NewsRepository
    NewsRepository - Model(Room)
    NewsRepository - Remote Data Source(Retrofit)
    https://developer.android.com/guide/?hl=ko
 */

/*
Android Fragment
    https://developer.android.com/training/basics/fragments/fragment-ui?hl=ko

 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            replace(IntroFragment.newInstance(),false)
        }
    }

    fun replace(fragment: Fragment, addBackStack: Boolean) {
        //https://developer.android.com/training/basics/fragments/fragment-ui?hl=ko
        val transaction = supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            if (addBackStack) {
                addToBackStack(null)
            }
        }
        // Commit the transaction
        transaction.commit();
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG,"onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")
    }
}