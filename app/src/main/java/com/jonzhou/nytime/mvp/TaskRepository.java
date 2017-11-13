package com.jonzhou.nytime.mvp;

/**
 * Created by jon on 17-10-22.
 */

public class TaskRepository implements TaskDataSource {

    private static TaskRepository INSTANCE = null;

    private final TaskDataSource mTasksRemoteDataSource;
    private final TaskDataSource mTasksLocalDataSource;


    public TaskRepository(TaskDataSource remoteDataSource, TaskDataSource localDataSouce) {
        this.mTasksRemoteDataSource = remoteDataSource;
        this.mTasksLocalDataSource = localDataSouce;
    }


    public static TaskRepository getInstance(TaskDataSource tasksRemoteDataSource, TaskDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TaskRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public void getTask() {
//        mTasksRemoteDataSource.getRemoteTask("home")
//                .compose(SwitchSchedulers.<BaseEntity<List<HomeResult>>>applaySchedulers())
//                .subscribe(new BaseObserver<List<HomeResult>>() {
//                    @Override
//                    protected void onSuccess(List<HomeResult> results) {
////                        mTasksView.showTasks(results);
//                    }
//                });
    }
}
