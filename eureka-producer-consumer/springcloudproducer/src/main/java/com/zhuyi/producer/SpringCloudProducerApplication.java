package com.zhuyi.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hutaoying on 2020/4/14
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProducerApplication.class,args);
    }
}
