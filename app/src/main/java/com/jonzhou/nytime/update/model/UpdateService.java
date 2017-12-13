package com.jonzhou.nytime.update.model;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by jon on 12/12/17.
 */

public class UpdateService extends Service {
    public static final String ACTION_DOWNLOAD = "intentservice.action.download";
    public static final String APK_DOWNLOAD_URL = "apk_download_url";
    public static final String APK_PATH = "apk_path";

    private final CompositeDisposable disposable = new CompositeDisposable();


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();
            String downUrl = intent.getStringExtra(APK_DOWNLOAD_URL);
            String apkPath = intent.getStringExtra(APK_PATH);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public static void startUpdateService(Context context, String url, String apkPath) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra(APK_DOWNLOAD_URL, url);
        intent.putExtra(APK_PATH, apkPath);
        context.startService(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
