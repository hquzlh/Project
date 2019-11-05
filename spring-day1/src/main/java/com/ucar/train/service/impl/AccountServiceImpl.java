package com.ucar.train.service.impl;

import com.ucar.train.service.IAccountService;

import java.util.Date;

/**
 * @program: spring
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-17 19:48
 **/

public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
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
