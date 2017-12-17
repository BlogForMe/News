package com.jonzhou.nytime.home.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.home.model.HomeContract;
import com.jonzhou.nytime.home.model.HomePresenter;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.mvp.rxbase.MvpFragment;
import com.jonzhou.nytime.util.DeviceInfo;
import com.jonzhou.nytime.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static com.jonzhou.nytime.util.Constants.tabTitles;

/**
 * Created by jon on 17-10-21.
 * 首页
 */

public class NewsFragment extends MvpFragment<HomePresenter> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager mLayoutManager;
    private HomeAdapter homeAdapter;

    public static Fragment newInstance(int itemId) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(FRAG_PARAMS_01, itemId);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String getItemFragment() {
        return tabTitles[getArguments().getInt(FRAG_PARAMS_01)];
    }

    @Override
    protected void requestData() {
        super.requestData();
//        onRefresh();
    }


    @Override
    protected void initView(View rootView) {
        mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        homeAdapter = new HomeAdapter(mContext);
        recyclerView.setAdapter(homeAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(mContext,
//                DividerItemDecoration.VERTICAL));
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onRefresh();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void showTasks(List<FinancialTimes> resultList) {
        homeAdapter.setData(resultList);
        Timber.d(resultList.toString());
    }

    @Override
    public void showLoading() {
       swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.getRemoteNews(getItemFragment(), DeviceInfo.apkKey);
    }

    @Override
    public void ErrorMsg(String msg) {

    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
        private Context context;
        private List<FinancialTimes> financialTimes;

        public HomeAdapter(Context mContext) {
            this.context = mContext;
        }

        void setData(List<FinancialTimes> FinancialTimes) {
            this.financialTimes = FinancialTimes;
            this.notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.tvTitle.setText(financialTimes.get(position).getTitle());
            holder.tvDescribe.setText(financialTimes.get(position).getDescription());
            GlideUtil.showImageView(getActivity(), financialTimes.get(position).getUrlToImage(), holder.ivImg);
            holder.llItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String urls = financialTimes.get(position).getUrl();
                    NewsWebActivity.statActivity(context, urls);
                }
            });
        }

        @Override
        public int getItemCount() {
            if (financialTimes == null) {
                return 0;
            }
            return financialTimes.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_title)
            TextView tvTitle;
            @BindView(R.id.tv_describe)
            TextView tvDescribe;
            @BindView(R.id.iv_img)
            ImageView ivImg;
            @BindView(R.id.ll_item)
            ConstraintLayout llItem;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
