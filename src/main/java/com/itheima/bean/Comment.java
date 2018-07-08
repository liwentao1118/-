package com.itheima.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;
    //评论的是哪个主题的帖子
    private String nid;
    //评论的内容
    private String content;
    //评论发表的时间
    private String time;
    //评论者的名称
    private String username;

    //评论者的IP地址
    private String ipaddress;
}
