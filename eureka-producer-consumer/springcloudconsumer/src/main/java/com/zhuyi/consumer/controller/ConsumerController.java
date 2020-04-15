package com.zhuyi.consumer.controller;

import com.zhuyi.consumer.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutaoying on 2020/4/14
 */
@RestController
public class ConsumerController {

    @Autowired
    com.zhuyi.consumer.service.HelloRemote HelloRemote;

    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name);
    }
}
