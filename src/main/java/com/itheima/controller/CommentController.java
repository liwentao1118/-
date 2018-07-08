package com.itheima.controller;

import com.itheima.bean.Comment;
import com.itheima.bean.User;
import com.itheima.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;
    @PostMapping("/add")
    public String add(String content ,String nid, Model model, HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        Comment comment  = new Comment();
            comment.setContent(content);
            comment.setIpaddress(request.getRemoteAddr());
            comment.setTime(new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(new Date()));
            comment.setUsername(user.getUsername());
            //nid代表的是页面上的主题帖子的唯一id 也可以代表这个评论属于哪个帖子的
            comment.setNid(nid);
            service.save(comment);
            return "redirect:/note/detail?nid="+nid;
    }
}
