package com.itheima.service;

import com.itheima.bean.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> findByUid(String uid);
}
