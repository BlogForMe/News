package com.jonzhou.nytime.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Created by jon on 17-10-21.
 */

public abstract class BaseFragment extends RxFragment {

    protected Context mContext;
    protected View rootView; //toutiao和开源中国的写法

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
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
            ButterKnife.bind(this, rootView);  //必须用this,用mContext报错　
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null)
                parent.removeView(rootView);
        }
        initView(rootView);
        return rootView;
    }

    protected abstract void initView(View rootView);

    protected abstract int setLayoutId();
}
