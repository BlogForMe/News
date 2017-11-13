package com.jonzhou.nytime.data.source.remote;

import com.jonzhou.nytime.mvp.TaskDataSource;


/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class TasksRemoteDataSource implements TaskDataSource {
    private static TasksRemoteDataSource INSTANCE;

    private TasksRemoteDataSource() {
    }

    public static TasksRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TasksRemoteDataSource();
        }
        return INSTANCE;
    }


    @Override
    public void getTask() {

    }


    /**
     * home　news
     *
     * @param type
     */
//    public Observable<BaseEntity<List<HomeResult>>> getRemoteTask(String type) {
//        return apiService.getRemoteNews(type);
//    }
}
