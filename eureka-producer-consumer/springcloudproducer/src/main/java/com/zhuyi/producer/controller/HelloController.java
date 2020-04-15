package com.zhuyi.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutaoying on 2020/4/14
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "hello"+ name;
    }
}
