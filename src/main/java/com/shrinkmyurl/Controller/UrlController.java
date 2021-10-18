package com.shrinkmyurl.Controller;

import com.shrinkmyurl.Entity.UrlMap;
import com.shrinkmyurl.Service.UrlMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlMapService service;

    @GetMapping("/hi")
    private String getString(){
        return "HelloWorld";
    }

    @GetMapping("/test")
    private List<UrlMap> test() {
        return service.getAllUrlMaps();
    }

    @GetMapping("/add")
    private String addTest() {
        service.addUrlMaps(new UrlMap("abc", "abcdefghijkl"));
        service.addUrlMaps(new UrlMap("abd", "abdskjbdjsgfkl"));
        service.addUrlMaps(new UrlMap("abe", "abcdefsdgsdmnfeiwofgjghijkl"));
        service.addUrlMaps(new UrlMap("abf", "abcdefgsdjkbvjksdvbhijkl"));
        service.addUrlMaps(new UrlMap("abg", "abcdefghijklsdnvosdhnvods"));
        return "done";
    }

}
