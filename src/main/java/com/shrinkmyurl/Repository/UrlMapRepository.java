package com.shrinkmyurl.Repository;

import com.shrinkmyurl.Entity.UrlMap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(collectionResourceRel = "url-map", path = "url-map")
public interface UrlMapRepository extends MongoRepository<UrlMap, String> {

    public UrlMap findByShortUrl(String shortUrl);
    public UrlMap findByLongUrl(String longUrl);
    public boolean existsUrlMapByLongUrl(String longUrl);
    public boolean existsUrlMapByShortUrl(String shortUrl);

    public List<UrlMap> findAllByAccessCount(int count);

}
