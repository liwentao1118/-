package com.itheima.service;

import com.itheima.bean.User;

public interface UserService {

    void register(User user);

    User findOne(String email, String password);

    User findByEmailAndMobile(String email,String mobile);


    void update(User user);

    User findlast(String email, String password);
}
