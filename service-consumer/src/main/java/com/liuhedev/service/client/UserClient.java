package com.liuhedev.service.client;

import com.liuhedev.service.config.FeignLogConfiguration;
import com.liuhedev.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuhe
 * @date 2020/06/15
 */
@FeignClient(value = "service-provider", fallback = UserClientFallback.class, configuration = FeignLogConfiguration.class)
// 标注该类是一个feign接口
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
