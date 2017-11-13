package com.jonzhou.nytime.home.model;

/**
 * Created by jon on 17-10-22.
 */

 /*public class HomePresenterextends BasePresenter implements HomeContract.Presenter {
    private final HomeContract.View mTasksView;
    private final TaskRepository homeRepository;

    public HomePresenter(HomeContract.View tasksView, TaskRepository tasksRepository) {

        homeRepository = Preconditions.checkNotNull(tasksRepository, "homeRepository cannot be null");
        mTasksView = Preconditions.checkNotNull(tasksView, "tasksView cannot be null!");
        mTasksView.setPresenter(this);
    }



    @Override
    public void subscribe() {
        loadTask(false);
    }

    public void loadTask(boolean forceUpdata) {
      loadTask();
    }

    private void loadTask() {
        homeRepository.getTask();

    }

    @Override
    public void ubsubscribe() {

    }
}
*/