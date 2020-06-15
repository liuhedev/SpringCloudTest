package com.liuhedev.service.service.impl;

import com.liuhedev.service.dao.UserMapper;
import com.liuhedev.service.pojo.User;
import com.liuhedev.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhe
 * @date 2020/06/11
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        // 模拟服务超时，触发服务降级
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.userMapper.selectByPrimaryKey(id);
    }
}
