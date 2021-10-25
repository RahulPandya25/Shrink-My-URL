package com.shrinkmyurl.Entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class UrlMap {
    @Id
    private String id;

    private String shortUrlKey;
    private String longUrl;
    private int accessCount;
    private Date expiresOn;
    private long timeToLive;

    public UrlMap() {}

    public UrlMap(String shortUrlKey, String longUrl, Date expiresOn) {
        this.shortUrlKey = shortUrlKey;
        this.longUrl = longUrl;
        this.expiresOn = expiresOn;
        this.accessCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getShortUrlKey() {
        return shortUrlKey;
    }

    public void setShortUrlKey(String shortUrlKey) {
        this.shortUrlKey = shortUrlKey;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public String toString() {
        return "UrlMap{" +
                "id='" + id + '\'' +
                ", shortUrlKey='" + shortUrlKey + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", accessCount=" + accessCount +
                ", expiresOn=" + expiresOn +
                ", timeToLive=" + timeToLive +
                '}';
    }
}
