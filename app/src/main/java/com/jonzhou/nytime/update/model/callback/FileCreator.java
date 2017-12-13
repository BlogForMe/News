package com.jonzhou.nytime.update.model.callback;


import com.jonzhou.nytime.update.entity.Update;

import java.io.File;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public interface FileCreator {
    /**
     * 根据update更新数据。创建一个对应的本地文件缓存路径。用于提供给{@link com.cqianjia.mng.main.update.model.base.DownloadWorker}下载任务使用。
     *
     * @param update 更新数据实体类
     * @return 下载文件本地路径，不能为null
     */
    File create(Update update);
}
