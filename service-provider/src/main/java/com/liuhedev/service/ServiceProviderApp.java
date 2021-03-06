package com.liuhedev.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liuhe
 * @date 2020/06/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.liuhedev.service.dao"})
public class ServiceProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApp.class, args);
    }
}
