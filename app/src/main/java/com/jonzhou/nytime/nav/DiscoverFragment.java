package com.jonzhou.nytime.nav;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonzhou.nytime.R;

/**
 * Created by jon on 17-10-21.
 */

public class DiscoverFragment extends Fragment {

    public static Fragment newInstance() {
        return new DiscoverFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover,container,false);
    }
}
