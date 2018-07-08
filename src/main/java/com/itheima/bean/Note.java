package com.itheima.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "note")
@Data
public class Note {
    @Id
    private String nid;
    //帖子的标题
    private String title;
    //帖子的内容
    private String content;
    //发帖的时间
    private String time;
    //谁发的帖子
    private String username;

    //发帖人的IP地址
    private String ipaddress;
    @OneToMany(mappedBy = "nid")
    private List<Comment> comments ;
}
