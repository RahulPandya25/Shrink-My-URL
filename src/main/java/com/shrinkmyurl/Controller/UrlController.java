package com.shrinkmyurl.Controller;

import com.shrinkmyurl.Entity.FetchUrlDTO;
import com.shrinkmyurl.Entity.UrlMap;
import com.shrinkmyurl.Entity.UrlMapDTO;
import com.shrinkmyurl.Service.UrlMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url")
// TODO: restrict this
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UrlController {

    @Autowired
    private UrlMapService service;

    @GetMapping("/{shortUrlKey}/{fetchStats}")
    private ResponseEntity accessThisUrl(@PathVariable String shortUrlKey, @PathVariable boolean fetchStats) {
        UrlMap map = service.findMapByShortUrlKey(shortUrlKey, fetchStats);
        if (map != null) {
            return ResponseEntity.ok().body(map);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/fetch")
    private ResponseEntity fetchMapUsingKey(@RequestBody FetchUrlDTO urlDTO) {
        UrlMap map = service.findMapBykey(urlDTO.getUrlKey(), urlDTO.isShortUrlKey());
        if (map != null) {
            return ResponseEntity.ok().body(map);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/shrink")
    private ResponseEntity shrinkThis(@RequestBody UrlMapDTO mapDTO) {
        UrlMap newMap = service.addNewMap(mapDTO);
        return ResponseEntity.ok().body(newMap);
    }


    ////////////////////////

    @GetMapping("/hi")
    private String getString(){
        return "HelloWorld";
    }

    @GetMapping("/all")
    private List<UrlMap> getAll() {
        return service.getAllMaps();
    }


}
