package com.jonzhou.nytime.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by jon on 17-10-21.
 */

public abstract class BaseFragment extends com.trello.rxlifecycle2.components.RxFragment {

    protected Context mContext;
    protected View rootView; //toutiao和开源中国的写法
    public static final String FRAG_PARAMS_01 = "FRAG_PARAMS_01";
    public static final String FRAG_PARAMS_02 = "FRAG_PARAMS_02";

    @Override
    public void onAttach(Activity activity) {
        mContext = activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(setLayoutId(), container, false);
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null)
                parent.removeView(rootView);
        }
        ButterKnife.bind(this, rootView);  //必须用this,用mContext报错　
        initView(rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.i("onResume() ----------------------------------------");
    }

    protected abstract void initView(View rootView);

    protected abstract int setLayoutId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    //  http://www.10tiao.com/html/565/201702/2247483988/1.html
    // 标志位，标志已经初始化完成，因为setUserVisibleHint是在onCreateView之前调用的，
    // 在视图未初始化的时候，在lazyLoad当中就使用的话，就会有空指针的异常
    private boolean isPrepared;
    //标志当前页面是否可见
    private boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.d(TAG + "         Test", " setUserVisibleHint() is Visible : ?  " + isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onInvisible() {

    }

    protected void onVisible() {
        lazyLoad();
    }

    private void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        requestData();
    }

    /**
     * 请求数据
     */
    protected void requestData() {
//        Log.d(TAG + "         Test", " requestData ");
    }
}
