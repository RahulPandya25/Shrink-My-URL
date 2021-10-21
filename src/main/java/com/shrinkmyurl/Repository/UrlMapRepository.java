package com.shrinkmyurl.Repository;

import com.shrinkmyurl.Entity.UrlMap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(collectionResourceRel = "url-map", path = "url-map")
public interface UrlMapRepository extends MongoRepository<UrlMap, String> {

    UrlMap findByShortUrlKey(String shortUrlKey);
    UrlMap findByLongUrl(String longUrl);
    boolean existsUrlMapByLongUrl(String longUrl);
    boolean existsUrlMapByShortUrlKey(String shortUrlKey);

}
