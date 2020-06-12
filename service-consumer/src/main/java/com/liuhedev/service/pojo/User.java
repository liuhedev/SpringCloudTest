package com.liuhedev.service.pojo;

import lombok.Getter;


/**
 * @author liuhe
 * @date 2020/06/11
 */
@Getter
public class User {

    private Long id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 性别，1男性，2女性
    private Integer sex;

    // 出生日期
    private String birthday;

}
