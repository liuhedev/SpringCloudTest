
package com.liuhedev.service.controller;

import com.liuhedev.service.client.UserClient;
import com.liuhedev.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 使用feign作为http客户端
 *
 * @author liuhe
 * @date 2020/06/11
 */
@RestController
@RequestMapping("consumer/user2")
public class UserController2 {

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id") Long id) {
        User user = userClient.queryById(id);
        return user;
    }
}
