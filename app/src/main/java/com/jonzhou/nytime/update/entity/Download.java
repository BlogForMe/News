package com.jonzhou.nytime.update.entity;

/**
 * Created by jon on 12/12/17.
 */

public class Download {
    private long total;
    private long byteReaded;

    public Download(long total, long byteReaded) {
        this.total = total;
        this.byteReaded = byteReaded;
    }
}
