package com.kkh.mynews.common

import android.content.Intent
import android.net.Uri
import com.kkh.mynews.MyNewsApplication
import com.kkh.mynews.common.Constant.Companion.EXTRA_URL
import com.kkh.mynews.view.WebViewActivity

class Util {
    companion object {
        fun openUrl(url: String) {
            val intent = Intent(MyNewsApplication.getAppContext(),WebViewActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            MyNewsApplication.getAppContext().startActivity(intent)
        }
    }
}