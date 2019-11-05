package com.hqu.bootjpa.controller;

import com.hqu.bootjpa.entity.User;
import com.hqu.bootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @program: boot-jpa
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-30 11:18
 **/
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User user1=userRepository.save(user);
        return user1;
    }
}
