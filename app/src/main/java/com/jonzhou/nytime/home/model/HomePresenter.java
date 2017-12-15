package com.jonzhou.nytime.home.model;

import com.jonzhou.nytime.base.entity.BaseNews;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.mvp.rxbase.BaseSubscriber;
import com.jonzhou.nytime.mvp.rxbase.RxPresenter;
import com.jonzhou.nytime.util.rxutil.RxBus;

import java.util.List;

import timber.log.Timber;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {


    @Override
    public void getRemoteNews(String type) {

        addSubscribe(apiService.getRemoteNews()
                        .compose(RxBus.<BaseNews<List<FinancialTimes>>>rxSchedulerHelper())
                .compose(RxBus.<List<FinancialTimes>>handResult())
                        .subscribeWith(new BaseSubscriber<List<FinancialTimes>>() {
                            @Override
                            public void onNext(List<FinancialTimes> financialTimes) {
                                Timber.d(financialTimes.toString());
                            }
                        })
        );
    }


}
