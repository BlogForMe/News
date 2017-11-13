package com.jonzhou.nytime.home;

import com.jonzhou.nytime.base.BaseEntity;
import com.jonzhou.nytime.home.model.entity.HomeResult;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jon on 17-10-22.
 *
 *
 */

public interface ApiService {

    @GET("v2/{type}.json?api-key=ce4f8036ce234ff9abf78c7a87d6caee")
    Flowable<BaseEntity<List<HomeResult>>> getRemoteNews(@Path("type") String type);
}
