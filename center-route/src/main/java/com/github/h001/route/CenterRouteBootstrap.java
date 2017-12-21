package com.github.h001.route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class CenterRouteBootstrap {
    public static void main(String[] args){
        SpringApplication.run(CenterRouteBootstrap.class, args);

        log.info("====================启动成功!====================");
    }
}
