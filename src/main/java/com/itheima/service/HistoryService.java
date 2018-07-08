package com.itheima.service;

import com.itheima.bean.Ballhistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoryService {


    List<Ballhistory> findAll();
    Ballhistory findOne(String code);
    Page<Ballhistory> findAll(Pageable pageable);
}
