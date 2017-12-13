package com.jonzhou.nytime.update.model;


import com.jonzhou.nytime.update.model.base.DownloadWorker;
import com.jonzhou.nytime.update.model.callback.DownloadCallback;
import com.jonzhou.nytime.update.model.callback.DownloadNotifier;
import com.jonzhou.nytime.update.model.callback.FileCreator;
import com.jonzhou.nytime.update.model.flow.UpdateExecutor;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class UpdateBuilder {
    private UpdateConfig config;
    private DownloadWorker downloadWorker;
    private DownloadNotifier downloadDialogCreator;
    private FileCreator fileCreator;

    public UpdateBuilder(UpdateConfig config) {
        this.config = config;
    }

    public DownloadCallback getDownloadCallback() {
        return config.getDownloadCB();
    }

    public DownloadWorker getDownloadWorker() {
        if (downloadWorker == null) {
            downloadWorker = config.getDownloadWorker();
        }
        return downloadWorker;
    }

    public UpdateExecutor getExecutor() {
        return config.getExecutor();
    }

    public DownloadNotifier getDownloadDialogCreator() {
        if (downloadDialogCreator == null) {
            downloadDialogCreator = config.getDownloadDialogCreator();
        }
        return downloadDialogCreator;
    }

    public FileCreator getFileCreator() {
        if (fileCreator == null) {
            fileCreator = config.getFileCreator();
        }
        return fileCreator;
    }

    public static UpdateBuilder create() {
        return create(UpdateConfig.getConfig());
    }

    private static UpdateBuilder create(UpdateConfig config) {
        return new UpdateBuilder(config);
    }
}
