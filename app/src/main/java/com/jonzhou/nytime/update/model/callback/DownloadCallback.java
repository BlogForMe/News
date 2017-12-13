package com.jonzhou.nytime.update.model.callback;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public interface DownloadCallback {
    /**
     * 启动下载任务
     * <p>回调线程：UI
     */
    void onDownloadStart();
}
