package com.liuhedev.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 触发Hystix服务降级的情况：
 * - 线程池已满
 * - 请求超时
 * <p>
 * Hystix解决雪崩问题的手段有两个：
 * - 线程隔离
 * - 服务熔断
 *
 * @author liuhe
 * @date 2020/06/11
 */
@EnableDiscoveryClient // 开启Eureka客户端
@SpringBootApplication
@EnableCircuitBreaker// 开启服务熔断
public class ServiceConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApp.class, args);
    }
}
