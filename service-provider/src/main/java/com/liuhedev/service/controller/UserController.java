package com.liuhedev.service.controller;

import com.liuhedev.service.pojo.User;
import com.liuhedev.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhe
 * @date 2020/06/11
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = this.iUserService.queryById(id);
        return user;
    }
}
