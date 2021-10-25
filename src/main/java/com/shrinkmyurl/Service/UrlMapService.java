package com.shrinkmyurl.Service;

import com.shrinkmyurl.Entity.UrlMap;
import com.shrinkmyurl.Entity.UrlMapDTO;
import com.shrinkmyurl.Repository.UrlMapRepository;
import com.shrinkmyurl.Utils.Constants;
import com.shrinkmyurl.Utils.RandomStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlMapService {

    @Autowired
    private UrlMapRepository repository;

    public UrlMap addNewMap(UrlMapDTO mapDTO) {
        UrlMap map = null;
        if (!repository.existsUrlMapByLongUrl(mapDTO.getLongUrl())) {
            String shortUrlKey = RandomStringUtil.generateWithLength(Constants.RANDOM_STRING_LENGTH, true, true);
            while (repository.existsUrlMapByShortUrlKey(shortUrlKey)) {
                shortUrlKey = RandomStringUtil.generateWithLength(Constants.RANDOM_STRING_LENGTH, true, true);
            }
            map = repository.save(new UrlMap(shortUrlKey, mapDTO.getLongUrl(), mapDTO.getTimeToLive()));
        } else {
            map = repository.findByLongUrl(mapDTO.getLongUrl());
        }
        return map;
    }

    public UrlMap findMapByShortUrlKey(String shortUrlKey, boolean fetchStats) {
        if (repository.existsUrlMapByShortUrlKey(shortUrlKey)) {
            UrlMap map = repository.findByShortUrlKey(shortUrlKey);
            if (!fetchStats) {
                map.setAccessCount(map.getAccessCount() + 1);
            }
            return repository.save(map);
        } else {
            return null;
        }
    }

    public UrlMap findMapBykey(String urlKey, boolean isShortUrlKey) {
        UrlMap map;
        if (isShortUrlKey) {
            String key = urlKey.substring(urlKey.lastIndexOf('/') + 1, urlKey.length());
            map = repository.existsUrlMapByShortUrlKey(key) ? repository.findByShortUrlKey(key) : null;
        } else {
            map = repository.existsUrlMapByLongUrl(urlKey) ? repository.findByLongUrl(urlKey) : null;
        }
        return map;
    }

    ////////////////////

    public List<UrlMap> getAllMaps() {
        return repository.findAll();
    }
}
