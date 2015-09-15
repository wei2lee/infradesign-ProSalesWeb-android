package com.infradesign.prosalesweb;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.web_view)
    WebView webView;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(view);
        ButterKnife.inject(this);
        WebViewClient webClient = new SSLTolerentWebViewClient();
        webView.setWebViewClient(webClient);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://salesbooking.hattengrp.com/SalesPlatform/Admin/Account/Login?returnUrl=%2FSalesPlatform%2FAdmin");
//        webView.loadUrl("https://salesbooking.hattengrp.com");
    }
}

class SSLTolerentWebViewClient extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed(); // Ignore SSL certificate errors
    }
}
