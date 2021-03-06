package com.jonzhou.nytime.mvp.rxbase;

import com.jonzhou.nytime.mvp.base.BaseView;

import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by jon on 17-10-24.
 */

public abstract class BaseSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String errorMsg;

    public BaseSubscriber() {
    }


    public BaseSubscriber(BaseView mView, String errorMsg) {
        this.mView = mView;
        this.errorMsg = errorMsg;
    }


    @Override
    public void onError(Throwable t) {
        if (mView == null) {
            return;
        }
        mView.ErrorMsg(t.getMessage());
        onFinish();
    }

    protected abstract void onFinish();


    @Override
    public void onComplete() {
        onFinish();
    }
}
