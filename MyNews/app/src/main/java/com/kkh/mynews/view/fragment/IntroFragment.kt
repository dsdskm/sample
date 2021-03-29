package com.kkh.mynews.view.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.databinding.FragmentIntroBinding
import com.kkh.mynews.databinding.ListBookItemLayoutBinding
import kotlin.concurrent.timer

class IntroFragment : ContentsFragment() {

    /*
    Animation
    크로스페이드
    카드플립 애니메이션
    회전표시 애니메이션

    https://developer.android.com/training/animation/reveal-or-hide-view?hl=ko
     */
    companion object {
        const val TAG = Constant.TAG_PREFIX + "IntroFragment"
        fun newInstance() = IntroFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            FragmentIntroBinding.inflate(LayoutInflater.from(container!!.context), container, false)
        startAnimation(view.root)
        /*
        Handler deprecated
        https://jae-young.tistory.com/25
        Handler(Looper.getMainLooper()).postDelayed({
            goFragment(MainFragment.newInstance())
        }, 1000)
         */


        return view.root
    }

    private fun startAnimation(view: View) {
        val contentView: View = view.findViewById(R.id.content)
        contentView.visibility = View.GONE
        val shortAnimationDuration = 500
        contentView.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        goFragment(MainFragment.newInstance(), false)
                    }
                })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG,"onViewStateRestored")
    }


}