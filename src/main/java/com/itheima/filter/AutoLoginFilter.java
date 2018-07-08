package com.itheima.filter;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/","/cart/*","/comment/*","/details","/note/*","/order/*","/upload","/get/**","/user/userUI"})
public class AutoLoginFilter implements Filter {
    @Autowired
    private UserService userService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("autologin filtert");

        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser!=null){
            chain.doFilter(req,resp);
            return ;
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("autoLogin".equals(cookie.getName())){
                String value = cookie.getValue();
               String email= value.split("#")[0];
                String password= value.split("#")[1];
                User user = userService.findlast(email,password);

                session.setAttribute("user",user);
                chain.doFilter(req,resp);
                return;
            }
        }
        response.sendRedirect("/user/loginUI");

    }

    @Override
    public void destroy() {

    }
}
