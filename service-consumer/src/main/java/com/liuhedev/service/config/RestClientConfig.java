package com.liuhedev.service.config;

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
    public RestTemplate getRestClient() {
        return new RestTemplate();
    }
}
