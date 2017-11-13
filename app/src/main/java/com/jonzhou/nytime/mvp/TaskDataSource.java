package com.jonzhou.nytime.mvp;

import com.jonzhou.nytime.base.BaseEntity;
import com.jonzhou.nytime.home.model.entity.HomeResult;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public interface TaskDataSource {
    void getTask();
}
