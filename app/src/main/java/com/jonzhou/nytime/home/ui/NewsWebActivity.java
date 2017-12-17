package com.jonzhou.nytime.home.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.base.BaseActivity;

import butterknife.BindView;
import timber.log.Timber;

/**
 * news detail
 */
public class NewsWebActivity extends BaseActivity {
    @BindView(R.id.wb_news)
    WebView wbNews;

    @BindView(R.id.progress)
    ProgressBar mProgress;


    public static void statActivity(Context context, String params) {
        Intent intent = new Intent(context, NewsWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS_01, params);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    @Override
    protected int setLayoutId() {
        return R.layout.activity_news_web;
    }

    @Override
    protected void initView() {
        setToolbarTitle("News");
        initWebView();
        String url = getIntent().getStringExtra(PARAMS_01);
        wbNews.loadUrl(url);

    }

    private void initWebView() {
        WebSettings webSettings = wbNews.getSettings();
        webSettings.setJavaScriptEnabled(true);// 启用支持javascript
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);// 优先使用缓存
        webSettings.setAllowFileAccess(true);//可以访问文件
        webSettings.setBuiltInZoomControls(true);//支持缩放
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            webSettings.setPluginState(WebSettings.PluginState.ON);
            webSettings.setDisplayZoomControls(false);// 支持缩放
        }
        wbNews.setWebViewClient(new MyWebViewClient());
        wbNews.setWebChromeClient(new MyWebChromeClient());
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgress.setVisibility(View.GONE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            mProgress.setProgress(newProgress);
        }


        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        wbNews.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wbNews.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (wbNews != null)
            wbNews.destroy();
    }
}
