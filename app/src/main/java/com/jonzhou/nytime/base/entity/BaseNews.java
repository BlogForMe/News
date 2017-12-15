package com.jonzhou.nytime.base.entity;

/**
 * Created by jon on 12/15/17.
 */

public class BaseNews<T> {
    private String status;
    private String totalResults;
    private T articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public T getArticles() {
        return articles;
    }
}
