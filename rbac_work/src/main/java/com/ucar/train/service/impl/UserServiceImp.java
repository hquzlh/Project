package com.ucar.train.service.impl;

import com.ucar.train.dao.UserDao;
import com.ucar.train.domain.Message;
import com.ucar.train.domain.User;
import com.ucar.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-20 09:33
 **/
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public Boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findByNameAndPassword(User user) {
        return userDao.findByNameAndPassword(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User findByUid(int uid) {
        return userDao.findByUid(uid);
    }

    @Override
    public void deleteByUid(int uid) {
        userDao.deleteByUid(uid);
    }
}
