package com.ucar.train.dao;

import com.ucar.train.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    /**
     *
     * @param uid 指定的员工id
     * @return  返回指定id的员工的所有权限
     */
    List<Permission> findPerByUid(int uid);

    /**
     *
     * @return  返回所有权限
     */
    List<Permission> findAllPer();

    /**
     * 删除指定权限
     * @param pid 需要删除的权限id
     */
    void deletePerByPid(int pid);

    /**
     * 更新权限
     * @param permission 需要更新的权限名
     */
    void updatePer(Permission permission);

    /**
     *  新增权限
     * @param permission  需要新增的权限
     */
    void insertPer(Permission permission);

    /**
     *  查找指定权限
     * @param pid
     * @return
     */
    Permission findByPid(int pid);


}
