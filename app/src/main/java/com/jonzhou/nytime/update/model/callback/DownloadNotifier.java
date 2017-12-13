package com.jonzhou.nytime.update.model.callback;

import android.app.Activity;

import com.jonzhou.nytime.update.entity.Update;


/**
 * Created by Administrator on 2017/12/13 0013.
 */

public interface DownloadNotifier {


    /**
     * 创建一个下载任务的下载进度回调。此回调将用于接收下载任务的状态并更新UI。
     *
     * @param update   更新数据实体类
     * @return 被创建的回调器。允许为null。
     */
    DownloadCallback create(Update update, Activity activity);

}
