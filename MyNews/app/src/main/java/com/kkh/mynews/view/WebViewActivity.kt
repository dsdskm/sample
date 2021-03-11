package com.kkh.mynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Constant.Companion.EXTRA_URL
import java.lang.Exception

class WebViewActivity : AppCompatActivity() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "WebViewActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url: String = intent.getStringExtra(EXTRA_URL).toString()
        Log.d(TAG, "onCreate url $url")

        val progress = findViewById<View>(R.id.progress)

        val myWebView = findViewById<WebView>(R.id.webview)
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.loadWithOverviewMode = true
        myWebView.settings.useWideViewPort = true
        myWebView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d(TAG,"onPageFinished")
                progress.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d(TAG,"shouldOverrideUrlLoading")
                return super.shouldOverrideUrlLoading(view, url)
            }
        }

        myWebView.loadUrl(url)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        finish()
    }
}