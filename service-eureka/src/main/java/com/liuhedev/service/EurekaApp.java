package com.liuhedev.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liuhe
 * @date 2020/06/12
 */
@SpringBootApplication
@EnableEurekaServer// 声明当前springboot应用是一个eureka服务中心
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
