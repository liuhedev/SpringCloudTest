package com.liuhedev.service.service;

import com.liuhedev.service.pojo.User;

/**
 * @author liuhe
 * @date 2020/06/11
 */
public interface IUserService {
    User queryById(Long id);
}
