package com.shrinkmyurl.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {

    @GetMapping("/hi")
    private String getString(){
        return "HelloWorld";
    }

}
