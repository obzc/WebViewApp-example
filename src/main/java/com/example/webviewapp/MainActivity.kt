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
        mWebView.loadUrl("https://nuxt-appwrite-project.vercel.app/")
        supportActionBar?.hide() // bar gizleme
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true // js disable etme
        webSettings.domStorageEnabled = true;
        webSettings.userAgentString = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
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