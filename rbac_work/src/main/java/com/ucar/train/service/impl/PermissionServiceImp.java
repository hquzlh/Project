package com.ucar.train.service.impl;

import com.ucar.train.dao.PermissionDao;
import com.ucar.train.domain.Permission;
import com.ucar.train.service.PermissionService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-21 13:54
 **/
@Service
public class PermissionServiceImp  implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findPerByUid(int uid) {
        permissionDao.findPerByUid(uid);
        return permissionDao.findPerByUid(uid);
    }

    @Override
    public List<Permission> findAllPer() {
        return permissionDao.findAllPer();
    }

    @Override
    public void deletePerByPid(int pid) {
        permissionDao.deletePerByPid(pid);
    }

    @Override
    public void updatePer(Permission permission) {
        permissionDao.updatePer(permission);
    }

    @Override
    public void insertPer(Permission permission) {
        permissionDao.insertPer(permission);
    }

    @Override
    public Permission findByPid(int pid) {
        return permissionDao.findByPid(pid);
    }
}
