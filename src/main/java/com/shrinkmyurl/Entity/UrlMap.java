package com.shrinkmyurl.Entity;

import org.springframework.data.annotation.Id;

public class UrlMap {
    @Id
    private String id;

    private String shortUrl;
    private String longUrl;
    private int accessCount;

    public UrlMap() {}

    public UrlMap(String shortUrl, String longUrl) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.accessCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    @Override
    public String toString() {
        return "UrlMap{" +
                "id=" + id +
                ", shortUrl='" + shortUrl + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", accessCount=" + accessCount +
                '}';
    }
}
