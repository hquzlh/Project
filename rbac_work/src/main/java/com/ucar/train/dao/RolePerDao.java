package com.ucar.train.dao;

import com.ucar.train.domain.Permission;
import com.ucar.train.domain.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolePerDao {
    /**
     * 弃用！！
     */
    void updatePermission();

    /**
     * 根据角色id查找权限
     * @param rid 角色id
     * @return
     */
    List<Permission> findPermissionByRid(int rid);

    /**
     * 删除指定角色的所有权限
     * @param rid
     */
    void deletePermissionByRid(int rid);

    /**
     * 新增角色的权限
     * @param rolePermission
     */
    void insertPermission(RolePermission rolePermission);

}
