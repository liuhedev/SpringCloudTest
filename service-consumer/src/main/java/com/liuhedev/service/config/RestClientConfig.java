package com.liuhedev.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * http请求客户端
 *
 * @author liuhe
 * @date 2020/06/11
 */
@Configuration
public class RestClientConfig {

    @Bean
    //开启负载均衡
    @LoadBalanced
    // Eureka中已经集成了Ribbon
    public RestTemplate getRestClient() {
        return new RestTemplate();
    }
}
