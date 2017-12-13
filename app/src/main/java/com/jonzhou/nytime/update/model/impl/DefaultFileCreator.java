package com.jonzhou.nytime.update.model.impl;

import android.os.Environment;

import com.jonzhou.nytime.update.entity.Update;
import com.jonzhou.nytime.update.model.callback.FileCreator;

import java.io.File;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class DefaultFileCreator implements FileCreator {
    @Override
    public File create(Update update) {
        File cacheDir = getCacheDir();
        cacheDir.mkdirs();
        return new File(cacheDir, "update_v_1.0.1");
    }

  /*  private File getCacheDir() {
//        Context context = ActivityManager.get().getApplicationContext();
        Context context = AppProfile.getInstance().getContext();
        File cacheDir = context.getExternalCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getCacheDir();
        }
        cacheDir = new File(cacheDir, "update");
        return cacheDir;
    }*/


    private File getCacheDir() {
//        Context context = ActivityManager.get().getApplicationContext();
//        Context context = AppProfile.getInstance().getContext();
        File cacheDir = Environment.getExternalStorageDirectory();
//        if (cacheDir == null) {
//            cacheDir = context.getCacheDir();
//        }
        cacheDir = new File(cacheDir, "update");
        return cacheDir;
    }
}