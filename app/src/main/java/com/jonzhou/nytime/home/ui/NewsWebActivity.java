package com.jonzhou.nytime.home.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
public class NewsWebActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.wb_news)
    WebView wbNews;

    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private static final String APP_CACHE_DIRNAME = "/webCache";
    private String newsUrl;

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
        newsUrl = getIntent().getStringExtra(PARAMS_01);
        swipeRefresh.setOnRefreshListener(this);
        onRefresh();
    }

    private void initWebView() {
        WebSettings webSettings = wbNews.getSettings();
        webSettings.setJavaScriptEnabled(true);// 启用支持javascript
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//缓存模式
        webSettings.setDomStorageEnabled(true); // 开启DOM storage API 功能
        // 开启database storage API功能
        webSettings.setDatabaseEnabled(true);
        webSettings.setAllowFileAccess(true);//可以访问文件
        webSettings.setBuiltInZoomControls(true);//支持缩放

        // 设置数据库缓存路径
        String cacheDirPath = getFilesDir().getAbsolutePath() + APP_CACHE_DIRNAME;
        webSettings.setAppCachePath(cacheDirPath);
        webSettings.setAppCacheEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            webSettings.setPluginState(WebSettings.PluginState.ON);
            webSettings.setDisplayZoomControls(false);// 支持缩放
        }
        wbNews.setWebViewClient(new MyWebViewClient());
        wbNews.setWebChromeClient(new MyWebChromeClient());
    }

    @Override
    public void onRefresh() {
        wbNews.loadUrl(newsUrl);
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
            swipeRefresh.setRefreshing(false);
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
