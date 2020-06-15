package com.liuhedev.service.client;

import com.liuhedev.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Feign fallback
 *
 * @author liuhe
 * @date 2020/06/15
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("服务器繁忙,请稍后再试！");
        return user;
    }
}
