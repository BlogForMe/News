package com.jonzhou.nytime.Demo;

/**
 * Created by Administrator on 2017/10/11 0011.
 * 利用泛型去适合服务器返回的所有的bean
 */

public class BaseEntity<T> {

    public int resultCode;
    public boolean success;
    public String message;
    public T data;
    public int msgType;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
}
