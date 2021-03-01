package com.kkh.mynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Constant.Companion.EXTRA_URL

class WebViewActivity : AppCompatActivity() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "WebViewActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url: String = intent.getStringExtra(EXTRA_URL).toString()
        Log.d(TAG, "onCreate url $url")

        val myWebView = findViewById<WebView>(R.id.webview)
        myWebView.loadUrl(url)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
        finish()
    }
}