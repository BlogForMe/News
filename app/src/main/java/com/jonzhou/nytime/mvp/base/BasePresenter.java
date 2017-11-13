package com.jonzhou.nytime.mvp.base;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public interface BasePresenter<T extends  BaseView> {

    void attachView(T view);

    void detachView();
//    void subscribe();
//    void ubsubscribe();
}
