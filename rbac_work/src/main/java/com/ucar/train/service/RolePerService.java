package com.ucar.train.service;

import com.ucar.train.domain.Permission;
import com.ucar.train.domain.RolePermission;

import java.util.List;

public interface RolePerService {
    List<Permission> findPermissionByRid(int rid);
    void deletePermissionByRid(int rid);
    void insertPermission(RolePermission rolePermission);
}
