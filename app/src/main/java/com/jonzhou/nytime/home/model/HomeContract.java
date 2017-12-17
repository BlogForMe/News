package com.jonzhou.nytime.home.model;

import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.home.model.entity.HomeResult;
import com.jonzhou.nytime.mvp.base.BasePresenter;
import com.jonzhou.nytime.mvp.base.BaseView;

import java.util.List;

/**
 * Created by jon on 17-10-22.
 */

public class HomeContract {

    /**
     * 对UI　的操作
     */
    public interface View extends BaseView {

        void showTasks(List<FinancialTimes> resultList);
        void showLoading();

        void hideLoading();
    }


    /**
     * View 对　Presenter的请求
     */
    public interface Presenter extends BasePresenter<View> {
        void getRemoteNews(String type,String apikey);
    }

}
