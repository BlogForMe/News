package com.jonzhou.nytime.home.model.entity;

/**
 * Created by jon on 12/15/17.
 */

public class FinancialTimes {

    /**
     * source : {"id":"financial-times","name":"Financial Times"}
     * author : null
     * title : EU gives UK go-ahead for next phase of Brexit talks
     * description : Negotiations to start on trade after leaders endorse progress on divorce settlement
     * url : https://www.ft.com/content/97ed6a98-e17a-11e7-a8a4-0a1e63a52f9c
     * urlToImage : http://prod-upp-image-read.ft.com/33aacc64-e17b-11e7-a0d4-0944c5f49e46
     * publishedAt : null
     */

    private SourceBean source;
    private Object author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Object publishedAt;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public Object getAuthor() {
        return author;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Object getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Object publishedAt) {
        this.publishedAt = publishedAt;
    }

    public static class SourceBean {
        /**
         * id : financial-times
         * name : Financial Times
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
