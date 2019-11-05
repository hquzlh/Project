package com.ucar.train.service.impl;

import com.ucar.train.service.IAccountService;

import java.util.Date;

/**
 * @program: spring
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-17 19:48
 **/

public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("保存对象成功"+name+age+birthday);
    }

    public void init() {
        System.out.println("出生");
    }

    public void destory() {
        System.out.println("销毁");
    }
}
