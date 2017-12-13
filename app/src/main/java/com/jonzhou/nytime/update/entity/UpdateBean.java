package com.jonzhou.nytime.update.entity;

/**
 * Created by jon on 12/11/17.
 */

public class UpdateBean {

    /**
     * version : 110
     * url : http://116.62.149.166:8301/v2/open/version/download
     * desc : 升级说明：
     * 优化部分功能
     */

    private int version;
    private String url;
    private String desc;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
