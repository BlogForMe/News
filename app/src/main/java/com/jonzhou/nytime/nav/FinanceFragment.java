package com.jonzhou.nytime.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonzhou.nytime.R;

/**
 * Created by jon on 17-10-21.
 */

public class FinanceFragment extends Fragment {
    public static Fragment newInstance() {
        FinanceFragment fragment = new FinanceFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_finance, container, false);
    }

}
