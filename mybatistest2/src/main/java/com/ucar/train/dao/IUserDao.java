package com.ucar.train.dao;

import com.ucar.train.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface  IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> finAll();
}
