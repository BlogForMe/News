package com.jonzhou.nytime.util;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 * 请求公有参数
 */

public class ParameterUtil {

    public static final String ACCESS_TOKEN = "accesstoken";   //token
    public static final String VERSION = "version"; //version
    public static final String OS = "os";


    public static Map<String, Object> getPostParams(Map<String, Object> map) {
        map.put(OS, "Android");
        map.put(VERSION, "1");
        return map;
    }
}
