package com.jonzhou.nytime.nav.finance;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jonzhou.nytime.R;
import com.jonzhou.nytime.home.model.HomeContract;
import com.jonzhou.nytime.home.model.HomePresenter;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.home.ui.NewsWebActivity;
import com.jonzhou.nytime.mvp.rxbase.MvpFragment;
import com.jonzhou.nytime.util.DeviceInfo;
import com.jonzhou.nytime.util.GlideUtil;
import com.jonzhou.nytime.util.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static com.jonzhou.nytime.util.Constants.tabTitles;

/**
 * Created by jon on 17-10-21.
 * 1　学习recycleView onitemclick点击事件
 * 2  不同的position显示处理
 */

public class FinanceFragment extends MvpFragment<FinancePresenter> implements IFinanceContract.View {
    private FinanceAdapter finaceAdapter;

    public static Fragment newInstance() {
        FinanceFragment fragment = new FinanceFragment();
        return fragment;
    }


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;

    @Override
    protected void initView(View rootView) {
        finaceAdapter = new FinanceAdapter();
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setAdapter(finaceAdapter);
        finaceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.showToast(getActivity(), " 提示 " + position);
            }
        });
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getRemoteNews(getItemFragment(), DeviceInfo.apkKey);


    }

    private String getItemFragment() {
        return tabTitles[0];
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_finance;
    }


    @Override
    public void showTasks(List<FinancialTimes> resultList) {
        finaceAdapter.setNewData(resultList);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void ErrorMsg(String msg) {

    }
}
