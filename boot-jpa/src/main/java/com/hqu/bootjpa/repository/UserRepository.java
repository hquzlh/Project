package com.hqu.bootjpa.repository;

import com.hqu.bootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {


}
