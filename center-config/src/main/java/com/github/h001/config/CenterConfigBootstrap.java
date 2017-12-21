package com.github.h001.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * Created by 2harvey on 2017年12月.
 */
@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigServer
public class CenterConfigBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CenterConfigBootstrap.class, args);
    }
}
