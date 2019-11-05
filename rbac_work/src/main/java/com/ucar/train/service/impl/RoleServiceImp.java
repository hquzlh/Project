package com.ucar.train.service.impl;

import com.ucar.train.dao.RoleDao;
import com.ucar.train.domain.Role;
import com.ucar.train.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-20 21:11
 **/
@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public void insertRole(Role role) {
        roleDao.insertRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(int rid) {
        roleDao.deleteRole(rid);
    }

    @Override
    public Role findByRid(int rid) {
        return roleDao.findByRid(rid);
    }
}
