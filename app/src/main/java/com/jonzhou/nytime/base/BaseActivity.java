package com.jonzhou.nytime.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.jonzhou.nytime.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by jon on 17-10-11.
 */

public abstract class BaseActivity extends RxAppCompatActivity {
    public final String TAG = getClass().getSimpleName();


    protected final static String PARAMS_01 = "PARAMS01";
    protected final static String PARAMS_02 = "PARAMS02";


    protected Context mContext;
    protected Toolbar mToolbar;

    protected TextView mToolBarTitle;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutId());

        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {            //toolbar显示到界面,判断null,需要考虑有的界面没添加toolbar
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolBarTitle = (TextView) findViewById(R.id.toolbar_title);
        mContext = this;
        if (mToolBarTitle != null) {
            //设置默认标题不显示
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        //显示默认返回键
        initView();

    }

    /**
     * 设置标题
     *
     * @return
     */
    protected void setToolbarTitle(CharSequence title) {
        if (mToolBarTitle != null && title != null) {
            mToolBarTitle.setText(title);
        }
    }


    protected abstract int setLayoutId();

    protected abstract void initView();

    /**
     * 导航栏是否显示后退按钮
     *
     * @return
     */
    protected boolean isShowBack() {
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mToolbar != null && isShowBack()) {
//            showBack();
        }
    }

    /**
     * 设置导航栏通用模式
     */
//    private void showBack() {
//        mToolbar.setNavigationIcon(R.mipmap.bt_back);//自定义返回键
//    }


    private CompositeDisposable mCompositeDisposable;

    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe();
    }
}
