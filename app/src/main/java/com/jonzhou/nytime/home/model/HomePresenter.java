package com.jonzhou.nytime.home.model;

import com.jonzhou.nytime.base.BaseEntity;
import com.jonzhou.nytime.home.model.entity.HomeResult;
import com.jonzhou.nytime.mvp.rxbase.BaseSubscriber;
import com.jonzhou.nytime.mvp.rxbase.RxPresenter;
import com.jonzhou.nytime.util.rxutil.RxUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {


    @Override
    public void getRemoteNews(String type) {

        addSubscribe(apiService.getRemoteNews(type)
                .compose(RxUtil.<BaseEntity<List<HomeResult>>>rxSchedulerHelper())
                .compose(RxUtil.<List<HomeResult>>handResult())
                .subscribeWith(new BaseSubscriber<List<HomeResult>>(mView) {

                    @Override
                    public void onNext(List<HomeResult> homeResults) {
                        mView.showTasks(homeResults);
                    }
                })

        );
    }


   /*    @Override
    public void getRemoteNews(String type) {
     apiService.getRemoteNews(type)
                .compose(SwitchSchedulers.<BaseEntity<List<HomeResult>>>applaySchedulers())
                .subscribe(new BaseObserver<List<HomeResult>>() {
                    @Override
                    protected void onSuccess(List<HomeResult> results) {
                        mTasksView.showTasks(results);
                        Timber.d(results.toString());
                    }
                });
    }*/
}
