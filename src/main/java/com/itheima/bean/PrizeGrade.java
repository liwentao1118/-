package com.itheima.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "prizegrade")
public class PrizeGrade {
//主键自增长
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;

    //中奖期数
    private String code;
    //几等奖
    private Integer type;

    //中了几注
    private Integer typenum;
    //中奖金额
    private Long typemoney;

    @Override
    public String toString() {
        return "PrizeGrade{" +
                "pid=" + pid +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", typenum=" + typenum +
                ", typemoney=" + typemoney +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypenum() {
        return typenum;
    }

    public void setTypenum(Integer typenum) {
        this.typenum = typenum;
    }

    public Long getTypemoney() {
        return typemoney;
    }

    public void setTypemoney(Long typemoney) {
        this.typemoney = typemoney;
    }
}
