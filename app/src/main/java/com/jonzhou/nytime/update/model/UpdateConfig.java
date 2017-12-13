package com.jonzhou.nytime.update.model;


import com.jonzhou.nytime.update.model.base.DownloadWorker;
import com.jonzhou.nytime.update.model.callback.DownloadNotifier;
import com.jonzhou.nytime.update.model.callback.FileCreator;
import com.jonzhou.nytime.update.model.flow.CallbackDelegate;
import com.jonzhou.nytime.update.model.flow.UpdateExecutor;
import com.jonzhou.nytime.update.model.impl.CustomApkFileCreator;
import com.jonzhou.nytime.update.model.impl.DefaultDownloadWorker;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class UpdateConfig {
    private static UpdateConfig DEFAULT;
    private CallbackDelegate callbackDelegate = new CallbackDelegate();
    private DownloadWorker downloadWorker;
    private DownloadNotifier downloadDialogCreator;

    private UpdateExecutor executor = new UpdateExecutor();
    private FileCreator fileCreator;

    public CallbackDelegate getDownloadCB() {
        return callbackDelegate;
    }

    public DownloadWorker getDownloadWorker() {
        if (downloadWorker == null) {
            downloadWorker = new DefaultDownloadWorker();
        }
        return downloadWorker;
    }

    public UpdateExecutor getExecutor() {
        return executor;
    }

    public DownloadNotifier getDownloadDialogCreator() {
//        if (downloadDialogCreator==null){
//            downloadDialogCreator = new  De
//        }
        return null;
    }

    public FileCreator getFileCreator() {
        if (fileCreator == null) {
            fileCreator = new CustomApkFileCreator();
        }
        return fileCreator;
    }

    public static UpdateConfig getConfig() {
        if (DEFAULT == null) {
            DEFAULT = new UpdateConfig();
        }
        return DEFAULT;
    }
}
