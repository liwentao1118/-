package com.itheima.service.impl;

import com.itheima.bean.Comment;
import com.itheima.dao.CommentDao;
import com.itheima.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public void save(Comment comment) {

        commentDao.save(comment);
    }
}
