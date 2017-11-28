package com.jonzhou.nytime.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.jonzhou.nytime.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jon on 17-10-11.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    public final  static String PARAMS_01="PARAMS01";
    public Context mContext;
//    @BindView(R.id.toolbar)
    Toolbar mToolbar;

//    @BindView(R.id.toolbar_title)
    TextView toolBarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar = findViewById(R.id.toolbar);
        toolBarTitle= findViewById(R.id.toolbar_title);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        if (mToolbar != null) {
            setToolbarTitle(toolBarTitle);
            setSupportActionBar(mToolbar);
        }
        initView();
    }

    /**
     * 设置标题
     *
     * @return
     */
    protected abstract void setToolbarTitle(TextView toolBarTitle);


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
            showBack();
        }
        //显示默认返回键
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //显示主标题
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * 设置导航栏通用模式
     */
    private void showBack() {
        mToolbar.setNavigationIcon(R.mipmap.bt_back);//自定义返回键
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
}
