package com.ucar.train.dao;

import com.ucar.train.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    /**
     *
     * @return 返回所有角色
     */
    List<Role> findAllRole();

    /**
     *  新增角色
     * @param role 角色信息
     */
    void insertRole(Role role);

    /**
     *  更新角色
     * @param role 角色信息
     */
    void updateRole(Role role);

    /**
     *
     * @param rid
     */
    void deleteRole(int rid);

    /**
     * 查找所有角色
     * @param rid  指定角色id
     * @return  返回指定角色信息
     */
    Role findByRid(int rid);
}
