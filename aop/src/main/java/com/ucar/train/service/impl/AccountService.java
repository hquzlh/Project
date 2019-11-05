package com.ucar.train.service.impl;

import com.ucar.train.service.IAccountService;

/**
 * @program: aop
 * @description:业务层实现类
 * @author: Mr.Zhu
 * @create: 2019-08-19 10:47
 **/

public class AccountService implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(String string) {
        System.out.println("执行了更新");

    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
