package com.ucar.training.dao;

import com.ucar.training.bean.Message;
import com.ucar.training.bean.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public interface UserDao {

    //根据账号密码查找用户
    User selectByNP(@Param("uname")String uname, @Param("pwd") String pwd) ;
    //新增留言
    void messageD(Message message);
    //检查用户名是否重复
    User selectByName(String uname);
    //新增用户
    void insertD(User user);

    //查询所有用户
    List<User> selectAll() ;
    //查询所有留言
    List<Message> selectMAll();
}
