package com.jonzhou.nytime.home.model;

import com.jonzhou.nytime.base.entity.BaseNews;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.mvp.rxbase.BaseSubscriber;
import com.jonzhou.nytime.mvp.rxbase.RxPresenter;
import com.jonzhou.nytime.util.DeviceInfo;
import com.jonzhou.nytime.util.rxutil.RxBus;

import java.util.HashMap;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {


    @Override
    public void getRemoteNews(String type, String apikey) {
        mView.showLoading();
        apikey = DeviceInfo.apkKey;
        addSubscribe(apiService.getRemoteNews(type, apikey)
                .compose(RxBus.<BaseNews<List<FinancialTimes>>>rxSchedulerHelper())
                .compose(RxBus.<List<FinancialTimes>>handResult())
                .subscribeWith(new BaseSubscriber<List<FinancialTimes>>() {
                    @Override
                    protected void onFinish() {
                        mView.hideLoading();
                    }

                    @Override
                    public void onNext(List<FinancialTimes> financialTimes) {
                        Timber.d(financialTimes.toString());
                        mView.showTasks(financialTimes);
                    }
                })
        );
    }


}
