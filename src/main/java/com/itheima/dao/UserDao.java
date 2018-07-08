package com.itheima.dao;

import com.itheima.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email, String password);

    User findByEmailAndMobile(String email ,String mibile);
}
