package com.shrinkmyurl.Controller;

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

    @GetMapping("/{shortUrlKey}")
    private ResponseEntity accessThisUrl(@PathVariable String shortUrlKey) {
        UrlMap map = service.findMapByShortUrlKey(shortUrlKey);
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
