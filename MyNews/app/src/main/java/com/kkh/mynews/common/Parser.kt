package com.kkh.mynews.common

import android.util.Log
import dagger.Provides
import javax.inject.Inject

class Parser @Inject constructor(){

    companion object{
        const val TAG = "[KKH]Parser"
    }

    fun print(){
        Log.d(TAG,"it is parser")
    }

}