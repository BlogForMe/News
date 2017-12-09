package com.jonzhou.nytime.retrofit;

import com.jonzhou.nytime.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jon on 17-10-22.
 * Http 请求配置和流程处理，部分Return 配置可以更加的简洁，为了试验，不简洁了
 * 1.问题
 * .retryOnConnectionFailure(false)以及设置了header("Connection", "Keep-Alive")
 * 是不是会导致http 请求 FAILED: java.io.IOException: unexpected end of stream on Connection
 */

public class ApiClient {
    public static Retrofit mRetrofit;

    private static final String baseUrl = "https://api.nytimes.com/svc/topstories/";

    private static Retrofit apiService;

    public static Retrofit retrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (apiService == null) {
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            builder.retryOnConnectionFailure(true)
                    .connectTimeout(11, TimeUnit.SECONDS)
                    .build();

            OkHttpClient okHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }


}
