package com.ucar.train.service;

import com.ucar.train.domain.Role;
import com.ucar.train.domain.UserRole;

public interface UserRoleService {
    void insertUserRole(UserRole userRole);
    void deleteUserRole(int uid);
    Role findUserRole(int uid);
    void defaultUserRole(int uid);
}
