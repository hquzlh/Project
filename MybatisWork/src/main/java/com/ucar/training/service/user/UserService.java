package com.ucar.training.service.user;

import com.ucar.training.bean.Message;
import com.ucar.training.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    /**
     * 编写留言
     *
     * @param message
     */
    void messageSer(Message message);

    /**
     * 检查用户名是否重复
     * @param uname
     * @return
     */
    Boolean  checkNameSer(String uname);

    /**
     * 检查用户登陆
     * @param uname
     * @param pwd
     * @return
     */
    Boolean checkUserSer(String uname, String pwd) ;

    /**
     * 增加用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> selectAll();

    /**
     * 获取所有留言
     * @return
     */
    List<Message> selectMAll();
    void destroy();
}
