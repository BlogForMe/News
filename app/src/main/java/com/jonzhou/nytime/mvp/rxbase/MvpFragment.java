package com.jonzhou.nytime.mvp.rxbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jonzhou.nytime.base.BaseFragment;
import com.jonzhou.nytime.mvp.base.BasePresenter;
import com.jonzhou.nytime.mvp.base.BaseView;
import com.jonzhou.nytime.util.CreateObjUtil;

/**
 * Created by Administrator on 2017/10/24 0024.
 * 参考geeknew
 *
 */

public abstract class MvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = CreateObjUtil.getT(this, 0);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }
}
