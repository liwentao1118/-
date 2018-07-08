package com.itheima.service.impl;

import com.itheima.bean.Order;
import com.itheima.dao.OrderDao;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order>findByUid(String uid) {
        return orderDao.findByUid(uid);
    }
}
