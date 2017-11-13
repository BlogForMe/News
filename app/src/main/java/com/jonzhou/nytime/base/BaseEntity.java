package com.jonzhou.nytime.base;

/**
 * Created by jon on 17-10-22.
 */

public class BaseEntity<T> {
    private String status;
    private String copyright;
    private String section;
    private String last_updated;
    private int num_results;
    private T results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseEntitiy{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", section='" + section + '\'' +
                ", last_updated='" + last_updated + '\'' +
                ", num_results=" + num_results +
                ", results=" + results +
                '}';
    }
}
