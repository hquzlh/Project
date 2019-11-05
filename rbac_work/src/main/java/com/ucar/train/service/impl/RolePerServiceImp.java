package com.ucar.train.service.impl;

import com.ucar.train.dao.RolePerDao;
import com.ucar.train.domain.Permission;
import com.ucar.train.domain.RolePermission;
import com.ucar.train.service.RolePerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-21 14:29
 **/
@Service
public class RolePerServiceImp implements RolePerService {
    @Autowired
    private RolePerDao rolePerDao;
    @Override
    public List<Permission> findPermissionByRid(int rid) {
        return rolePerDao.findPermissionByRid(rid);
    }

    @Override
    public void deletePermissionByRid(int rid) {
        rolePerDao.deletePermissionByRid(rid);
    }

    @Override
    public void insertPermission(RolePermission rolePermission) {
        rolePerDao.insertPermission(rolePermission);
    }
}
