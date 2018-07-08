package com.itheima.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String ,CartItem> map = new HashMap<String ,CartItem>();

    public void add(CartItem cartItem){

        String balls = cartItem.getRed()+"-"+cartItem.getBlue();
        if (map.containsKey(balls)){
            map.get(balls).setCount(map.get(balls).getCount()+1);
        }else {
            map.put(balls,cartItem);
        }
    }
    public void delete(String key){
        map.remove(key);
    }
    public void clear(){
        map.clear();
    }
    public double gettotal(){
        double total = 0;
        for (String key : map.keySet()) {
           total+= map.get(key).getSubTotal();
        }
        return total;
    }
    public Collection<CartItem> getCartItem(){
        return  map.values();

    }
}
