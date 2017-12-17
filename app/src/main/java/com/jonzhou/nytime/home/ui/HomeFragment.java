package com.jonzhou.nytime.home.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jonzhou.nytime.R;
import com.jonzhou.nytime.base.BaseFragment;

import butterknife.BindView;

import static com.jonzhou.nytime.util.Constants.tabTitles;

/**
 * Created by jon on 12/16/17.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    public static Fragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected void initView(View rootView) {
        viewPager.setAdapter(new NewsPagerAdapter(getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(tabTitles.length - 1);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewPager.setAdapter(null);
    }

    /**
     * 使用　{@link android.support.v13.app.FragmentStatePagerAdapter}
     * 　兼容{@link android.app.Fragment}
     * <p>
     * 这里用　FragmentStatePagerAdapter点其他tab回来后崩溃
     * {@sample https://stackoverflow.com/questions/45665709/using-fragmentstatepageadapter-to-retain-position-for-fragment-with-viewpager }
     */
    class NewsPagerAdapter extends FragmentPagerAdapter {


        public NewsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return NewsFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }
}
