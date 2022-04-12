package com.example.webviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mWebView =findViewById<View>(R.id.WebView) as WebView
        mWebView.loadUrl("https://blog.wmtools.me")
        supportActionBar?.hide() // bar gizleme
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true // js disable etme
        mWebView.webViewClient = WebViewClient()


        // geri tuşu ve aşağı çekme hareketlerinde ne yapacağı
        mWebView.canGoBack()
        mWebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK
                && event.action == MotionEvent.ACTION_UP
                    && mWebView.canGoBack()){
            mWebView.goBack()
            return@OnKeyListener true
        }
            false
        })

    }
}