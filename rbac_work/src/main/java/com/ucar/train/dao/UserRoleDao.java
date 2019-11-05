package com.ucar.train.dao;

import com.ucar.train.domain.Role;
import com.ucar.train.domain.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao {
    /**
     * 新增用户角色关系
     * @param userRole
     */
    void insertUserRole(UserRole userRole);

    /**
     * 删除用户角色关系
     * @param uid
     */
    void deleteUserRole(int uid);

    /**
     * 查找用户对应的角色
     * @param uid
     * @return
     */
    Role findUserRole(int uid);

    /**
     * 删除指定用户对应的角色关系
     * @param uid
     */
    void defaultUserRole(int uid);
}
