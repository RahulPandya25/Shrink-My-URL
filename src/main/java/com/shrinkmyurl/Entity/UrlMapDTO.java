package com.shrinkmyurl.Entity;

public class UrlMapDTO {
    private String longUrl;
    private long timeToLive;

    public UrlMapDTO(String longUrl, long timeToLive) {
        this.longUrl = longUrl;
        this.timeToLive = timeToLive;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public String toString() {
        return "UrlMapDTO{" +
                "longUrl='" + longUrl + '\'' +
                ", timeToLive=" + timeToLive +
                '}';
    }
}
