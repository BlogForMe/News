package com.jonzhou.nytime.update.model.flow;


import com.jonzhou.nytime.update.entity.Update;
import com.jonzhou.nytime.update.model.UpdateBuilder;
import com.jonzhou.nytime.update.model.base.DownloadWorker;
import com.jonzhou.nytime.update.model.impl.DefaultDownloadCallback;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class Launcher {
    private static Launcher launcher;

    public static Launcher getInstance() {
        synchronized (Launcher.class) {
            if (launcher == null) {
                launcher = new Launcher();
            }
        }
        return launcher;
    }


    /**
     * 调起apk文件下载任务。
     *
     * @param update  更新api实体类。不能为null
     * @param builder 更新任务实例
     */
    public void launchDownload(Update update, UpdateBuilder builder) {
        // 定义一个默认的下载状态回调监听。用于接收文件下载任务所发出的通知。并链接下载后续流程
        DefaultDownloadCallback downloadCallback = new DefaultDownloadCallback();
        downloadCallback.setBuilder(builder);
        downloadCallback.setUpdate(update);
        DownloadWorker downloadWorker = builder.getDownloadWorker();


        builder.getExecutor().download(downloadWorker);

    }

}
