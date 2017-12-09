package com.jonzhou.nytime.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.base.BaseFragment;

import timber.log.Timber;

/**
 * Created by jon on 17-10-21.
 */

public class FinanceFragment extends BaseFragment {
    public static Fragment newInstance() {
        FinanceFragment fragment = new FinanceFragment();
        return fragment;
    }


    @Override
    protected void initView(View rootView) {
        Timber.tag("FinanceFragment");
        rootView.findViewById(R.id.bt_finance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.d("fjjjjjjjjjjfjjjjjjjjj");
            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_finance;
    }

}
