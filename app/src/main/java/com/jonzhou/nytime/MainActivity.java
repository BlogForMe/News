package com.jonzhou.nytime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.jonzhou.nytime.home.ui.HomeFragment;
import com.jonzhou.nytime.nav.DiscoverFragment;
import com.jonzhou.nytime.nav.FinanceFragment;
import com.jonzhou.nytime.nav.MineFragment;

import timber.log.Timber;

/**
 * http://wl9739.github.io/2016/10/20/BottomNavigationView-%E7%9A%84%E4%BD%BF%E7%94%A8/
 * <p>
 * https://material.io/guidelines/components/bottom-navigation.html#
 */
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavagition;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        // Make sure the data in repository is the latest.
        // Also to void the repo only contains a package
        // when user has already gone to detail page
        // by check a notification or widget.
//        TaskRepository.destroyInstance();
        // Init the presenters.
//        homePresenter = new HomePresenter(fragments[0],
//                TaskRepository.getInstance(TasksRemoteDataSource.getInstance(), TasksLocalDataSource.getInstance()));

    }


    public static Fragment[] getFragments() {
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance();
        fragments[1] = FinanceFragment.newInstance();
        fragments[2] = DiscoverFragment.newInstance();
        fragments[3] = MineFragment.newInstance();
        return fragments;
    }

    private void onTabItemSelected(int itemId) {
        //每次new
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch (itemId) {
            case R.id.nv_home:
                fragment = fragments[0];
                break;
            case R.id.nv_invest:
                fragment = fragments[1];
                break;
            case R.id.nv_map:
                fragment = fragments[2];
                break;
            case R.id.nv_mine:
                fragment = fragments[3];
                break;
        }
        beginTransaction.replace(R.id.fl_bottom, fragment).commit();

    }

    private void showMsg(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}
