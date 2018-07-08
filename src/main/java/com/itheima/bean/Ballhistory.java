package com.itheima.bean;

import javax.persistence.*;
import java.security.KeyStore;
import java.util.List;

@Entity(name = "ballhistory")
public class Ballhistory {
@Id
//中奖期数
    private String code;
//中奖类型
    private String name;
    //开奖日期
    private String date;
    //开奖的星期
    private String week;
    //红球号码
    private String red;
    //蓝球号码
    private String blue;
    //总销售金额
    private String sales;
    //奖池金额
    private String poolmoney;
    //中奖详细信息
    private String content;

    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER,mappedBy="code")
    private List<PrizeGrade> prizeGrades;

    @Override
    public String toString() {
        return "Ballhistory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", red='" + red + '\'' +
                ", blue='" + blue + '\'' +
                ", sales='" + sales + '\'' +
                ", poolmoney='" + poolmoney + '\'' +
                ", content='" + content + '\'' +
                ", prizeGrades=" + prizeGrades +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPoolmoney() {
        return poolmoney;
    }

    public void setPoolmoney(String poolmoney) {
        this.poolmoney = poolmoney;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PrizeGrade> getPrizeGrades() {
        return prizeGrades;
    }

    public void setPrizeGrades(List<PrizeGrade> prizeGrades) {
        this.prizeGrades = prizeGrades;
    }
}
