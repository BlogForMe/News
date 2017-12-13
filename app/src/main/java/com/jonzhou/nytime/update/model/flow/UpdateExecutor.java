package com.jonzhou.nytime.update.model.flow;

import android.support.annotation.NonNull;


import com.jonzhou.nytime.update.model.base.DownloadWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class UpdateExecutor {

    private static ExecutorService pool;

    public UpdateExecutor() {
        pool = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Update Dispatcher");
                thread.setDaemon(true);
                return thread;
            }
        });

    }

    public void download(DownloadWorker downloadWorker) {
//        downloadWorker.setRunning(true);
        pool.execute(downloadWorker);
    }
}
