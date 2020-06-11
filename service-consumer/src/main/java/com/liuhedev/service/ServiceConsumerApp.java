package com.liuhedev.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author liuhe
 * @date 2020/06/11
 */
// 因在根pom中有设置jdbc，所以spring如果不加排除datasource设置，会报错Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
public class ServiceConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApp.class, args);
    }
}
