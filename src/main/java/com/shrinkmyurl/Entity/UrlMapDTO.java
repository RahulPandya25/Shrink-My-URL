package com.shrinkmyurl.Entity;

public class UrlMapDTO {
    private String longUrl;
    private int timeToLive;

    public UrlMapDTO(String longUrl, int timeToLive) {
        this.longUrl = longUrl;
        this.timeToLive = timeToLive;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
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
