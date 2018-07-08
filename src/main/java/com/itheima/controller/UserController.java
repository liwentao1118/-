package com.itheima.controller;

import com.aliyuncs.exceptions.ClientException;
import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.utils.BALLUtils;
import com.itheima.utils.MD5Utils;
import com.itheima.utils.SmsUtil;
import com.itheima.utils.UUIDUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/register")
    public String register(User user, String code, HttpSession session, Model model){
        String  sessionCode = (String) session.getAttribute("code");
        if (!code.equals(sessionCode)){
            model.addAttribute("msg","验证码有误");
            return "register";
        }else{
            user.setState(1);
            user.setHeadimg("/img/IMG_0452.JPG");
            user.setMoney(100);
            user.setUid(UUIDUtils.getId());
            service.register(user);
        }

        return "redirect:/user/loginUI";
    }
    @GetMapping("/sendsms")
    @ResponseBody
    public String sendSms(String mobile,HttpSession session) throws ClientException {
        String code = SmsUtil.sendSms(mobile);
        session.setAttribute("code",code);
        return "success";
    }
    @RequestMapping("/registerUI")
    public String registerUi(){
        return "register";
    }
    @PostMapping("login")
    public String login(String email, String password, HttpSession session, Model model, HttpServletResponse response){
        User user = service.findOne(email, password);
        if(user!=null){
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("autoLogin",email+"#"+MD5Utils.encode(password,"@@@@"));
            cookie.setMaxAge(60*10);
            //之前是在/user 调用的addCookie,它默认的path就是"/user"
            cookie.setPath("/");
            response.addCookie(cookie);
            System.out.println(cookie.getValue());
            String  requsetURI = (String) session.getAttribute("requsetURI");
            if (requsetURI!=null){
                return "redirect:"+requsetURI;
            }
            return "redirect:/";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }


    }
    @RequestMapping("/loginUI")
    public String loginUI(){

        return "login";
    }
    @RequestMapping("/userUI")
    public String UserUI(Model model){
        model.addAttribute("redballs",BALLUtils.getRed());
        model.addAttribute("blueball",BALLUtils.getBlue());
        return "myself";
    }
    @PostMapping("/reset")
    public String reset(String email ,String mobile,String code,String password, Model model,HttpSession session){
        String sessioncode = (String) session.getAttribute("code");
        if (!code.equals(sessioncode)){
            model.addAttribute("errormsg","验证码错误");
            return "reset";
        }
        User user = service.findByEmailAndMobile(email, mobile);
        if(user==null){
            model.addAttribute("errorusermsg","用户名或者密码错误");
            return "reset";
        }

        user.setPassword(password);
        System.out.println(password);
        System.out.println(user);
        service.register(user);
        return "redirect:/user/loginUI";
    }
    @RequestMapping("/resetUI")
    public String resetUI(){
        return "reset";
    }
    @GetMapping("/reLogin")
    public String reLogin(){
        return "redirect:/user/loginUI";
    }
    @GetMapping("/outLogin")
    public String outLogin(HttpSession session){
            session.removeAttribute("user");
            return "redirect:/";
    }
    @GetMapping("/iconUI")
    public String iconUI(){
        return "icon";
    }
}
