package com.jonzhou.nytime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import timber.log.Timber;

public class TimberTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timber_test);
        Timber.tag("DemoActivity");
    }

    public void btLOG(View v) {
        Timber.d("提示");
    }
}
