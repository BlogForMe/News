package com.jonzhou.nytime.data.source.local;

import com.jonzhou.nytime.mvp.TaskDataSource;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class TasksLocalDataSource implements TaskDataSource {
    private static TasksLocalDataSource INSTANCE;

    private TasksLocalDataSource() {
    }

    public static TasksLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TasksLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getTask() {

    }
}
