package com.ucar.training.dao;

import com.ucar.training.bean.Message;
import com.ucar.training.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;
import java.util.List;

public interface AdminDao {

    //检查管理员账号密码
    User selectByNP(@Param("uname")String uname, @Param("pwd") String pwd);
    //检查用户名是否重复
    User selectByName(String uname);
    //删除用户
    void deleteD(String name);
    //删除留言
    void deleteMD(@Param("name") String name, @Param("date") String date);
    //更新用户
    void updateD (User user);
    //新增管理员
   void insertD(User admin);
    //新增用户
    void insertUserD(User user);
    //查询单个用户
    User selectD(String name);
    //查询所有用户
    List<User> selectUAll();
    //查询所有管理员
    List<User> selectAAll();
    //查询所有留言
    List<Message> selectMAll();
}
