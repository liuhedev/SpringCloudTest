package com.liuhedev.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author liuhe
 * @date 2020/08/04
 */
@SpringBootApplication
@EnableConfigServer  //开启配置服务
public class SpringTestConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringTestConfigApp.class, args);
    }
}
