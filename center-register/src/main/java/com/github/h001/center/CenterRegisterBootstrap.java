package com.github.h001.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 *
 * @author 2harvey
 * 2017年12月21日
 */
@EnableEurekaServer  //启动一个服务注册中心提供给其他应用进行对话
@SpringBootApplication
public class CenterRegisterBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CenterRegisterBootstrap.class, args);
    }
}
