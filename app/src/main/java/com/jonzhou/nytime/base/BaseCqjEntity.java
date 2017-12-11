package com.jonzhou.nytime.base;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class BaseCqjEntity<T> {

    /**
     * success : true
     * data : {"version":110,"url":"http://116.62.149.166:8301/v2/open/version/download","desc":"升级说明：\n优化部分功能"}
     * total : 0
     * msgType : 0
     */

    private boolean success;
    private T data;
    private int total;
    private int msgType;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
}
