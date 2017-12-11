package com.jonzhou.nytime.home;

import com.jonzhou.nytime.base.BaseCqjEntity;
import com.jonzhou.nytime.base.BaseEntity;
import com.jonzhou.nytime.home.model.entity.HomeResult;
import com.jonzhou.nytime.update.entity.Update;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jon on 17-10-22.
 */

public interface ApiService {

    @GET("v2/{type}.json?api-key=ce4f8036ce234ff9abf78c7a87d6caee")
    Flowable<BaseEntity<List<HomeResult>>> getRemoteNews(@Path("type") String type);

    @FormUrlEncoded
    @POST("v2/open/version/getVersion")
    Flowable<BaseCqjEntity<Update>> checkUpdate(@FieldMap Map<String, Object> map);


}
