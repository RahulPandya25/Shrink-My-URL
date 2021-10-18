package com.shrinkmyurl.Service;

import com.shrinkmyurl.Entity.UrlMap;
import com.shrinkmyurl.Repository.UrlMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlMapService {

    @Autowired
    private UrlMapRepository repository;

    public List<UrlMap> getAllUrlMaps() {
        return repository.findAllByAccessCount(0);
    }

    public UrlMap addUrlMaps(UrlMap map) {
        return repository.save(map);
    }

}
