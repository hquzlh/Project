package com.ucar.train.service;

import com.ucar.train.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    void insertRole(Role role);
    void updateRole(Role role);
    void deleteRole(int rid);
    Role findByRid(int rid);
}
