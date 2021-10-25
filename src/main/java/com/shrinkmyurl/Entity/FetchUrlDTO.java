package com.shrinkmyurl.Entity;

public class FetchUrlDTO {
    private String urlKey;
    private boolean isShortUrlKey;

    public FetchUrlDTO(String urlKey, boolean isShortUrlKey) {
        this.urlKey = urlKey;
        this.isShortUrlKey = isShortUrlKey;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public boolean isShortUrlKey() {
        return isShortUrlKey;
    }

    public void setShortUrlKey(boolean shortUrlKey) {
        isShortUrlKey = shortUrlKey;
    }

    @Override
    public String toString() {
        return "FetchUrlDTO{" +
                "longUrl='" + urlKey + '\'' +
                ", isShortUrlKey=" + isShortUrlKey +
                '}';
    }
}
