package com.ucar.train.service;

import com.ucar.train.domain.Message;
import com.ucar.train.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    Boolean insertUser(User user);
    User findByNameAndPassword(User user);
    Boolean updateUser(User user);
    User findByUid(int uid);
    void deleteByUid(int uid);
}
