package com.jonzhou.nytime;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.jonzhou.nytime.base.BaseActivity;
import com.jonzhou.nytime.base.BaseCqjEntity;
import com.jonzhou.nytime.home.ApiService;
import com.jonzhou.nytime.home.ui.HomeFragment;
import com.jonzhou.nytime.mvp.rxbase.BaseSubscriber;
import com.jonzhou.nytime.nav.DiscoverFragment;
import com.jonzhou.nytime.nav.FinanceFragment;
import com.jonzhou.nytime.nav.MineFragment;
import com.jonzhou.nytime.retrofit.ApiClient;
import com.jonzhou.nytime.update.entity.Update;
import com.jonzhou.nytime.update.ui.UpdateDialogFragment;
import com.jonzhou.nytime.util.DeviceInfo;
import com.jonzhou.nytime.util.ParameterUtil;

import java.util.HashMap;

/**
 * http://wl9739.github.io/2016/10/20/BottomNavigationView-%E7%9A%84%E4%BD%BF%E7%94%A8/
 * <p>
 * https://material.io/guidelines/components/bottom-navigation.html#
 */
public class MainActivity extends BaseActivity {
    public static String TAG_DIALOG_INVESTPWD = "TAG_DIALOG_UPDATE_CHECK";

    private BottomNavigationView mBottomNavagition;
    private Fragment[] fragments;

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

    public void btUpdate(View v) {
        update();
    }


    private void update() {
//        addSubscribe(ApiClient.retrofit().create(ApiService.class).checkUpdate(ParameterUtil.getPostParams(new HashMap<String, Object>()))
//                        .compose(RxUtil.<BaseCqjEntity<Update>>rxSchedulerHelper())
////                .compose(RxUtil.<Update>handResult())
//                        .subscribeWith(new BaseSubscriber<BaseCqjEntity<Update>>() {
//                            @Override
//                            public void onNext(BaseCqjEntity<Update> updateBaseCqjEntity) {
//                                int versionCode = 0/*updateBaseCqjEntity.getData().getVersion()*/;
//                                if (versionCode > DeviceInfo.loadVersionInfo(mContext)) {
//                                    UpdateDialogFragment upDialog = new UpdateDialogFragment();
//                                    upDialog.show(getFragmentManager(), TAG_DIALOG_INVESTPWD);
//                                }
//                            }
//                        })
//        );
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
