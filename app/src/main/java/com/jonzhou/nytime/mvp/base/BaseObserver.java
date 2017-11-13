package com.jonzhou.nytime.mvp.base;


import com.jonzhou.nytime.base.BaseEntity;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by jon on 17-10-22.
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {
    private Disposable disposable;


    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(@NonNull BaseEntity<T> tBaseEntity) {
        if (!disposable.isDisposed()){
            disposable.dispose();
        }
        if ("OK".equals(tBaseEntity.getStatus())){
            onSuccess(tBaseEntity.getResults());
        }
    }

    protected abstract void onSuccess(T results);

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
