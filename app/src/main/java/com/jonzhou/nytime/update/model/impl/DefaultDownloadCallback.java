package com.jonzhou.nytime.update.model.impl;

import android.app.Activity;

import com.jonzhou.nytime.update.entity.Update;
import com.jonzhou.nytime.update.model.UpdateBuilder;
import com.jonzhou.nytime.update.model.callback.DownloadCallback;
import com.jonzhou.nytime.update.util.ActivityManager;


/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class DefaultDownloadCallback implements DownloadCallback {

    private UpdateBuilder builder;
    // 通过UpdateConfig或者UpdateBuilder所设置的下载回调监听。通过此监听器进行通知用户下载状态
    private DownloadCallback downloadCB;
    private Update update;

    // 通过DownloadCreator所创建的回调监听，通过此监听器进行下载通知的UI更新
    private DownloadCallback processCB;

    public void setBuilder(UpdateBuilder builder) {
        this.builder = builder;
        downloadCB = builder.getDownloadCallback();
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    @Override
    public void onDownloadStart() {
        try {
            if (downloadCB != null) {
                downloadCB.onDownloadStart();
            }
            processCB = getProcessCb();
            if (processCB != null) {
                processCB.onDownloadStart();
            }

        } catch (Throwable t) {
//            onDownloadError(t);
        }
    }

    private DownloadCallback getProcessCb() {
        if (processCB != null) {
            return processCB;
        }
        Activity current = ActivityManager.get().topActivity();
        processCB = builder.getDownloadDialogCreator().create(update, current);
        return processCB;
    }
}
