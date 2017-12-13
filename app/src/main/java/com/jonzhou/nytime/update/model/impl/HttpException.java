package com.jonzhou.nytime.update.model.impl;

/**
 * 内部提供的一个异常。用于标识及提供在网络操作中出现的异常。
 * Created by Administrator on 2017/12/13 0013.
 */

public class HttpException extends RuntimeException {
    private int code;
    private String errMsg;

    public HttpException(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public int getCode() {
        return code;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
