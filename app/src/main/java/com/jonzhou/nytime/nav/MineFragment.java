package com.jonzhou.nytime.nav;

import android.app.Fragment;
import android.view.View;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.base.BaseFragment;

/**
 * Created by jon on 17-10-21.
 */

public class MineFragment extends BaseFragment {
    public static Fragment newInstance() {
        return new MineFragment();
    }


    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_mine;
    }
}
