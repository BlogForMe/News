package com.jonzhou.nytime.nav.finance;

import com.jonzhou.nytime.base.entity.BaseNews;
import com.jonzhou.nytime.home.model.HomeContract;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.mvp.rxbase.RxPresenter;
import com.jonzhou.nytime.util.DeviceInfo;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class FinancePresenter extends RxPresenter<IFinanceContract.View> implements IFinanceContract.Presenter {


    @Override
    public void getRemoteNews(String type, String apikey) {
        mView.showLoading();
        apikey = DeviceInfo.apkKey;
        addSubscribe(apiService.getRemoteNews(type, apikey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<BaseNews<List<FinancialTimes>>>() {
                    @Override
                    public void onNext(BaseNews<List<FinancialTimes>> listBaseNews) {
                        mView.showTasks(listBaseNews.getArticles());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();

                    }
                }));

    }


}
