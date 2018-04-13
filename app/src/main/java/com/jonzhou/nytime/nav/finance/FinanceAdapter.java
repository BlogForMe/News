package com.jonzhou.nytime.nav.finance;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jonzhou.nytime.R;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;

public class FinanceAdapter extends BaseQuickAdapter<FinancialTimes, BaseViewHolder> {
    public FinanceAdapter() {
        super(R.layout.item_news);
    }

    @Override
    protected void convert(BaseViewHolder helper, FinancialTimes item) {
        if (helper.getLayoutPosition() == 0) {
            helper.setText(R.id.tv_title,"你好");
        } else {
            helper.setText(R.id.tv_title, item.getTitle());
            helper.setText(R.id.tv_describe, item.getDescription());
        }

    }
}
