package com.itheima.dao;

import com.itheima.bean.Ballhistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryDao extends JpaRepository<Ballhistory,String> {

}
