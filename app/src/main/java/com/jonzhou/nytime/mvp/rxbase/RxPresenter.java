package com.jonzhou.nytime.mvp.rxbase;

import com.jonzhou.nytime.home.ApiService;
import com.jonzhou.nytime.mvp.base.BasePresenter;
import com.jonzhou.nytime.mvp.base.BaseView;
import com.jonzhou.nytime.retrofit.ApiClient;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    private CompositeDisposable mCompositeDisposable;
    protected ApiService apiService;

    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }


    @Override
    public void attachView(T view) {
        this.mView = view;
        apiService = ApiClient.retrofit().create(ApiService.class);
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
