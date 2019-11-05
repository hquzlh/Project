package com.ucar.train.service;

/**
 * 业务层接口
 */
public interface IAccountService {
    void saveAccount();
    void updateAccount(String s);
    int deleteAccount();
}
