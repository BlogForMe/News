package com.jonzhou.nytime.update.model.impl;

import android.os.Environment;


import com.jonzhou.nytime.update.entity.Update;
import com.jonzhou.nytime.update.model.callback.FileCreator;

import java.io.File;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class CustomApkFileCreator implements FileCreator {
    @Override
    public File create(Update update) {
        // 根据传入的versionName创建一个文件。供下载时网络框架使用
        File path = new File(Environment.getExternalStorageDirectory().getPath() + "/ApkUpdate");
        path.mkdirs();
        return new File(path, "apk_1.1.0");
    }
}
