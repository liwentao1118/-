package com.itheima.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    //订单编号
    @Id
    private String oid;

    //订单创建的时间
    private Date createTime;

    //订单状态 : 0 未付款, 1:待开奖, 2:已中奖, 3:已兑奖, 4:未中奖
    private int state;

    //订单总金额
    private double total;

    //所述哪个用户
    private String uid;

    // 记录所有订单项
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "oid")
    private List<OrderItem> orderItems;
}