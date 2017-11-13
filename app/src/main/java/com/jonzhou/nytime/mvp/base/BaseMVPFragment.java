package com.jonzhou.nytime.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jonzhou.nytime.base.BaseFragment;
import com.jonzhou.nytime.home.model.HomeContract;
import com.jonzhou.nytime.home.model.entity.HomeResult;

import java.util.List;

/**
 * Created by jon on 17-10-21.
 * https://github.com/AnyLifeZLB/Android-MVP-Rxjava2/tree/master
 */

public  abstract class BaseMVPFragment extends BaseFragment /*implements HomeContract.View */{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

//    @Override
//    public void setPresenter(HomeContract.Presenter presenter) {
//
//    }
//
//    @Override
//    public void showTasks(List<HomeResult> resultList) {
//
//    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int setLayoutId() {
        return 0;
    }
}
