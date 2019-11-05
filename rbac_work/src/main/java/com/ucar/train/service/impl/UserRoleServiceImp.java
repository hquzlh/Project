package com.ucar.train.service.impl;

import com.ucar.train.dao.UserRoleDao;
import com.ucar.train.domain.Role;
import com.ucar.train.domain.UserRole;
import com.ucar.train.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-21 17:20
 **/
@Service
public class UserRoleServiceImp  implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public void insertUserRole(UserRole userRole) {
        userRoleDao.insertUserRole(userRole);
    }

    @Override
    public void deleteUserRole(int uid) {
        userRoleDao.deleteUserRole(uid);
    }

    @Override
    public Role findUserRole(int uid) {
        return userRoleDao.findUserRole(uid);
    }

    @Override
    public void defaultUserRole(int uid) {
        userRoleDao.defaultUserRole(uid);
    }
}
