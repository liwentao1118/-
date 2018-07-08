package com.itheima.filter;

import com.itheima.bean.User;
import com.itheima.utils.MD5Utils;
import org.springframework.data.repository.query.RepositoryQuery;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

@WebFilter(urlPatterns = {"/note/publish","/comment/add","/cart/*","/user/userUI"})

public class CheckLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("checklogin filter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("/user/loginUI");
            String requestURI = request.getRequestURI();
            request.getSession().setAttribute("requsetURI",requestURI);
            return ;
        }else{
            chain.doFilter(req,resp);
        }


    }

    @Override
    public void destroy() {

    }
}
