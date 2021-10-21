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

    public UrlMap findMapByShortUrlKey(String shortUrlKey) {
        if (repository.existsUrlMapByShortUrlKey(shortUrlKey)) {
            UrlMap map = repository.findByShortUrlKey(shortUrlKey);
            map.setAccessCount(map.getAccessCount() + 1);
            return repository.save(map);
        } else {
            return null;
        }
    }

    ////////////////////

    public List<UrlMap> getAllMaps() {
        return repository.findAll();
    }
}
