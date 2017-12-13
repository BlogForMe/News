package com.jonzhou.nytime.update.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class ActivityManager implements Application.ActivityLifecycleCallbacks {

    private static ActivityManager manager = new ActivityManager();
    private Context applicationContext;


    public static ActivityManager get() {
        return manager;
    }

    private LinkedList<Activity> stack = new LinkedList<>();

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (!stack.contains(activity)) {
            stack.add(activity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (stack.contains(activity)) {
            stack.remove(activity);
        }
    }

    public Activity topActivity() {
        Activity activity = null;
        if (!stack.isEmpty()) {
            activity = stack.getLast();
        }
        return activity;
    }

    public Context getApplicationContext() {
        return  applicationContext;
    }
}
