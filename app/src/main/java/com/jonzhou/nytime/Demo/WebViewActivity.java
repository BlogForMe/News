package com.jonzhou.nytime.Demo;

import android.content.Context;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.base.BaseActivity;
import com.jonzhou.nytime.util.ToastUtil;


public class WebViewActivity extends BaseActivity {
//    private static final String API_TEST = "http://116.62.149.166:8601";
//    String sss= "192.168.10.117:9011";

    String ss = "http://192.168.10.117:9011/v2/open/identityVerification.jsp";
    //    String ss = "http://116.62.149.166:8601/v2/accept/account/accountVerifyPage?UserId=3184&accesstoken=7BD65D8EFD6046EBB68CF59E76959EEA&Platform=2&os=ios&version=1000000";
    private WebView mWebView;

    @Override
    protected void setToolbarTitle(TextView toolBarTitle) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initView() {

        mWebView = (WebView) findViewById(R.id.wb_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");   // android点击h5回调
//        mWebView.loadUrl("file:///android_asset/test.html");
        mWebView.loadUrl(ss);
//        mWebView.setWebChromeClient(new WebChromeClient());
//
//        mWebView.loadUrl(ss);
//
//
//        String html = "参数";
//        mWebView.loadUrl("javascript:readFromNative('" + html + "')");
    }


    public void btParam(View view) {
//        String html = "参数";
        // 传递参数调用JS的方法
//        mWebView.loadUrl("javascript:readFromNative('" + html + "')");


//       mWebView.loadUrl("javascript:readFromNative('" + html + "');");

//        String color = "#00ee00";
//        mWebView.loadUrl("javascript:changeColor('" + color + "');");
    }


    class HybridInterface {
        Context context;

        public HybridInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public void getUserKey(String userKey) {
            ToastUtil.showToast(context, userKey);
        }
    }


    class WebAppInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Show a toast from the web page
         */
        @JavascriptInterface
        public void btClose() {
            Toast.makeText(mContext, "dd", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}