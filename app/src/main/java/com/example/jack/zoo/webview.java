package com.example.jack.zoo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {
    WebView mwebview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mwebview = findViewById(R.id.wv);
        WebSettings webSettings = mwebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mwebview.setWebViewClient(new WebViewClient());
        mwebview.loadUrl("https://cloud.taipei/web_tzo_getNavigationIframeList");
    }

    @Override public boolean onKeyDown ( int keyCode, KeyEvent event)
    {
        String weburl = mwebview.getUrl();
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            if(mwebview.canGoBack())
                mwebview.goBack();
            else
                this.finish();
        }

        return true;
    }
}
