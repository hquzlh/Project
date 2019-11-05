package com.ucar.train.dao;

import com.ucar.train.domain.Message;
import com.ucar.train.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Repository("userDao")
public interface UserDao {
    /**
     * 查找所有角色
     * @return
     */
    List<User> findAllUser();

    /**
     * 新增角色
     * @param user  角色信息
     * @return
     */
    Boolean insertUser(User user);

    /**
     * 根据账号密码查找角色
     * @param user
     * @return
     */
    User findByNameAndPassword(User user);

    /**
     * 更新角色信息
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    /**
     * 根据用户id查找角色
     * @param uid
     * @return
     */
    User findByUid(int uid);

    /**
     * 删除指定角色
     * @param uid
     */
    void deleteByUid(int uid);
}
