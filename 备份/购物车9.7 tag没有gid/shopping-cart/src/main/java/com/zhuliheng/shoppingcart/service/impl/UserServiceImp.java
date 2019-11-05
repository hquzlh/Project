package com.zhuliheng.shoppingcart.service.impl;

import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.UserMoneyDto;
import com.zhuliheng.shoppingcart.mapper.GoodsMapper;
import com.zhuliheng.shoppingcart.mapper.UserMapper;
import com.zhuliheng.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:12
 **/
@Service
public class UserServiceImp  implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User checkUser(User user) {
        return userMapper.checkUser(user);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateMoney(UserMoneyDto userMoneyDto) {
        userMapper.updateMoney(userMoneyDto);
    }
}
