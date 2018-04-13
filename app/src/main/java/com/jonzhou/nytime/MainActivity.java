package com.jonzhou.nytime;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.jonzhou.nytime.base.BaseActivity;
import com.jonzhou.nytime.home.ui.HomeFragment;
import com.jonzhou.nytime.nav.finance.FinanceFragment;
import com.jonzhou.nytime.nav.MineFragment;

import java.util.HashMap;

/**
 * http://wl9739.github.io/2016/10/20/BottomNavigationView-%E7%9A%84%E4%BD%BF%E7%94%A8/
 * <p>
 * https://material.io/guidelines/components/bottom-navigation.html#
 */
public class MainActivity extends BaseActivity {

    private BottomNavigationView mBottomNavagition;
    private HashMap<Integer, Fragment> fragments;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fragments = getFragments();
        mBottomNavagition = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNavagition.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });
        onTabItemSelected(R.id.nv_home);//默认进入
    }


    public static HashMap<Integer, Fragment> getFragments() {
        HashMap<Integer, Fragment> fragmentHashMap = new HashMap<>();
        fragmentHashMap.put(R.id.nv_home, HomeFragment.newInstance());
//        fragments[1] = FinanceFragment.newInstance();
        fragmentHashMap.put(R.id.nv_invest, FinanceFragment.newInstance());
//        fragmentHashMap.put(R.id.nv_invest, DiscoverFragment.newInstance());
        fragmentHashMap.put(R.id.nv_mine, MineFragment.newInstance());
        return fragmentHashMap;
    }

    private void onTabItemSelected(int itemId) {
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.fl_bottom, fragments.get(itemId));
//        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fm.addToBackStack(null);
        fm.commit();
    }
}
