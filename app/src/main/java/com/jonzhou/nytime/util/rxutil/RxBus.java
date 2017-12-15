package com.jonzhou.nytime.util.rxutil;

import com.jonzhou.nytime.base.entity.BaseNews;
import com.jonzhou.nytime.retrofit.ApiException;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jon on 17-10-22.
 */

public class RxBus{


    /**
     * 线程Ui切换
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<BaseNews<T>, T> handResult() {
        return new FlowableTransformer<BaseNews<T>, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<BaseNews<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<BaseNews<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull BaseNews<T> tBaseNews) throws Exception {
                        if ("ok".equals(tBaseNews.getStatus()))
                            return createData(tBaseNews.getArticles());
                        else
                            return Flowable.error(new ApiException(""));
                    }
                });
            }
        };
    }

    private static <T> Flowable<T> createData(final T results) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(results);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }

            }
        }, BackpressureStrategy.BUFFER);
    }


}
