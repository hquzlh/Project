package com.ucar.training.service.admin;

import com.ucar.training.bean.Message;
import com.ucar.training.bean.User;

import java.util.List;

public interface AdminService {
    /**
     * 根据账号密码查找用户是否存在
     * @param uname
     * @param pwd
     * @return
     */
    Boolean checkAdminSer(String uname, String pwd);

    /**
     * 根据用户名查找用户名是否存在
     * @param uname
     * @return
     */
    Boolean  checkNameSer(String uname );

    /**
     * 删除用户
     * @param name
     */
    void deleteSer(String name);

    /**
     * 删除留言
     * @param name
     * @param date
     */
    void deleteMSer(String name, String date);

    /**
     * 更新用户信息
     * @param user
     */
    void updateSer(User user);

    /**
     * 增加管理员
     * @param admin
     */
    void insertSer(User admin);

    /**
     * 增加用户
     * @param user
     */
    void insertUserSer(User user);

    /**
     * 查询用户
     * @param name
     * @return
     */
    User  selectUser(String name);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectUALl();

    /**
     * 查询所有管理员
     * @return
     */
    List<User> selectAAll();

    /**
     * 查询所有留言
     * @return
     */
    List<Message> selectMAll();
    void destroy();
}
