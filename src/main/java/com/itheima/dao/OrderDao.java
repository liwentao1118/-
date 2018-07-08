package com.itheima.dao;

import com.itheima.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order ,String> {
    List<Order> findByUid(String uid);
}
