package com.kkh.mynews.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kkh.mynews.MainActivity

open class ContentsFragment : Fragment() {

    lateinit var mMainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainActivity = activity as MainActivity

    }

    fun goFragment(fragment: Fragment,addBackStack: Boolean) {
        mMainActivity.replace(fragment,addBackStack)
    }

}