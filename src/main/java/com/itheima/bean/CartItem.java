package com.itheima.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class CartItem {
    private String red;

    private String blue;

    private int count = 1;

    private double price = 2.00;

    private double subTotal;

    public double getSubTotal (){
        return count*price;
    }

}
