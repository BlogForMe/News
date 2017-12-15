package com.jonzhou.nytime.home;

import com.jonzhou.nytime.base.BaseCqjEntity;
import com.jonzhou.nytime.base.entity.BaseNews;
import com.jonzhou.nytime.home.model.entity.FinancialTimes;
import com.jonzhou.nytime.update.entity.Update;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by jon on 17-10-22.
 */

public interface ApiService {

    @GET("https://newsapi.org/v2/top-headlines?sources=financial-times&apiKey=e4f505f73a9f4ee99119ab33a19ab05e")
    Flowable<BaseNews<List<FinancialTimes>>> getRemoteNews();

    @FormUrlEncoded
    @POST("v2/open/version/getVersion")
    Flowable<BaseCqjEntity<Update>> checkUpdate(@FieldMap Map<String, Object> map);


}
