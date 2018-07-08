package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    @Override
    public void register(User user) {
        String password = user.getPassword();
        password = MD5Utils.encode(password,"@@@@");
        user.setPassword(password);
        dao.save(user);
    }

    @Override
    public User findOne(String email, String password) {
        password = MD5Utils.encode(password,"@@@@");
        return dao.findByEmailAndPassword(email,password);
    }

    @Override
    public User findByEmailAndMobile(String email,String mobile) {

         return dao.findByEmailAndMobile(email,mobile);
    }

    @Override
    public void update(User user) {
        dao.save(user);
    }

    @Override
    public User findlast(String email, String password) {
        return dao.findByEmailAndPassword(email,password);
    }


}
