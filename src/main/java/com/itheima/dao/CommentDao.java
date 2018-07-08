package com.itheima.dao;

import com.itheima.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Integer> {


}
