package com.ucar.train.service;

import com.ucar.train.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findPerByUid(int uid);
    List<Permission> findAllPer();
    void deletePerByPid(int pid);
    void updatePer(Permission permission);
    void insertPer(Permission permission);
    Permission findByPid(int pid);
}
