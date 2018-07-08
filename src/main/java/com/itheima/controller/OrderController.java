package com.itheima.controller;

import com.itheima.bean.*;
import com.itheima.service.OrderService;
import com.itheima.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/details")
    public String listdetail(HttpSession session , Model model){
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setOid(UUIDUtils.getId());
        order.setState(0);
        order.setUid(user.getUid());
        order.setTotal(cart.gettotal());
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (CartItem cartItem : cart.getCartItem()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBlue(cartItem.getBlue());
            orderItem.setRed(cartItem.getRed());
            orderItem.setCode("2018023");
            orderItem.setCount(cartItem.getCount());
            orderItem.setOid(order.getOid());
            orderItem.setItemid(UUIDUtils.getId());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        model.addAttribute("order",order);
        orderService.save(order);

        return "orderlist";
    }
    @GetMapping("/mylists")
    public String myLists(HttpSession session ,Model model){
         User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.findByUid(user.getUid());
        model.addAttribute("orders",orders);
         return "mylist";
    }
}
