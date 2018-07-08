package com.itheima.controller;

import com.alibaba.fastjson.JSONArray;
import com.itheima.bean.Cart;
import com.itheima.bean.CartItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("/selectUI")
    public String selectUI(String flag, Model model){

            model.addAttribute("flag",flag);

            return "selected";
    }
    @PostMapping("/addToCart")
    @ResponseBody
    public Map<String ,Integer> addToCart(String balls, HttpSession session){

        List<CartItem> cartItems = JSONArray.parseArray(balls, CartItem.class);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart ==null){
            cart= new Cart();
            session.setAttribute("cart",cart);
        }

        for (CartItem cartItem : cartItems) {
                cart.add(cartItem);
            System.out.println(cartItem);
        }
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("cartSize",cart.getCartItem().size());
        return map;
    }
    @GetMapping("/cartUI")
    public String cartUI(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        return "cart";
    }
    @GetMapping("/clear")
    public String clearAll(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.clear();
        return "redirect:/cart/cartUI";
    }
    @GetMapping("/remove")
    public String removeOne(HttpSession session,String key){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.delete(key);
        return "redirect:/cart/cartUI";
    }

}
