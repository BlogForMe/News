package com.jonzhou.nytime.home.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.home.model.HomeContract;
import com.jonzhou.nytime.home.model.HomePresenter;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.mvp.rxbase.MvpFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by jon on 17-10-21.
 * 首页
 */

public class HomeFragment extends MvpFragment<HomePresenter> implements  HomeContract.View {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private HomeAdapter homeAdapter;
    private HomeContract.Presenter presenter;

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getRemoteNews("financial-times");
    }

    @Override
    protected void initView(View rootView) {
        mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        homeAdapter = new HomeAdapter(mContext);
        recyclerView.setAdapter(homeAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(mContext,
//                DividerItemDecoration.VERTICAL));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void showTasks(List<FinancialTimes> resultList) {
        homeAdapter.setData(resultList);
        Timber.d(resultList.toString());
    }



    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
        private Context context;
        private List<FinancialTimes> FinancialTimess;

        public HomeAdapter(Context mContext) {
            this.context = mContext;
        }

        void setData(List<FinancialTimes> FinancialTimess) {
            this.FinancialTimess = FinancialTimess;
            this.notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.tvTitle.setText(FinancialTimess.get(position).getTitle());
//            holder.tvDescribe.setText(FinancialTimess.get(position).getSubsection());
//            holder.tvTime.setText(FinancialTimess.get(position).getPublished_date());
            holder.llItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String urls = FinancialTimess.get(position).getUrl();
                    NewsWebActivity.statActivity(context, urls);
                }
            });
        }

        @Override
        public int getItemCount() {
            if (FinancialTimess == null) {
                return 0;
            }
            return FinancialTimess.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_title)
            TextView tvTitle;
            @BindView(R.id.tv_describe)
            TextView tvDescribe;
            @BindView(R.id.tv_time)
            TextView tvTime;
            @BindView(R.id.ll_item)
            LinearLayout llItem;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
