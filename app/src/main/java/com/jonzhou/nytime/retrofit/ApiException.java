package com.jonzhou.nytime.retrofit;

/**
 * Created by jon on 17-10-24.
 */

public class ApiException extends  Exception {
    private  int code;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(int code) {
        this.code = code;
    }

}
