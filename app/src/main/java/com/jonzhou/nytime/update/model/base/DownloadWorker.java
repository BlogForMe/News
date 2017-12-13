package com.jonzhou.nytime.update.model.base;



import com.jonzhou.nytime.update.entity.Update;
import com.jonzhou.nytime.update.model.UpdateBuilder;
import com.jonzhou.nytime.update.model.impl.DefaultDownloadCallback;
import com.jonzhou.nytime.update.util.ThreadUtil;

import java.io.File;

/**
 * Created by Administrator on 2017/12/13 0013.
 * 此为下载任务的封装基类。主要用于对下载中的进度、状态进行派发。以起到连接更新流程作用
 */

public abstract class DownloadWorker implements Runnable {


    /**
     * {@link DefaultDownloadCallback} 的实例。用于接收下载状态并进行后续流程通知
     */
    private DefaultDownloadCallback downloadCallback;

    protected UpdateBuilder builder;
    private Update update;


    @Override
    public void run() {
        try {
//            sendDownloadStart();
            File cacheFile = builder.getFileCreator().create(update);
//            if (cacheFile!=null&&cacheFile.exists())
//        String url =
//            String updateUrl = update.getUpdateUrl();
            String updateUrl = "";
            cacheFile.getParentFile().mkdirs();
            download(updateUrl, cacheFile);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    protected abstract void download(String url, File target) throws Exception;

    private void sendDownloadStart() {
        if (downloadCallback == null) return;
        ThreadUtil.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                if (downloadCallback == null) return;
                downloadCallback.onDownloadStart();
            }
        });
    }
}
