package com.jonzhou.nytime.update.util;

import android.os.Handler;
import android.os.Looper;


/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class ThreadUtil {
    private static Handler handler;

    /**
     * 提供一个Main Handler。用于将更新状态派发传递到主线程中进行通知
     *
     * @return MainHandler
     */
    public static Handler getMainHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }
}
