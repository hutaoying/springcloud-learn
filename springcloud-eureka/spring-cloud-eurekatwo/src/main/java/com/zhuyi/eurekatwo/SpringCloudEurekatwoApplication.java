package com.zhuyi.eurekatwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekatwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekatwoApplication.class,args);
    }
}
