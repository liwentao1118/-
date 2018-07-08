package com.itheima.service.impl;

import com.itheima.bean.Ballhistory;
import com.itheima.dao.HistoryDao;
import com.itheima.service.HistoryService;
import javafx.collections.transformation.SortedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao dao;
    @Override
    public List<Ballhistory> findAll() {

        return  dao.findAll( new Sort(Sort.Direction.DESC,"code"));
    }

    @Override
    public Ballhistory findOne(String code) {
            return dao.findOne(code);
    }
    public Page<Ballhistory> findAll(Pageable pageable){
          return   dao.findAll(pageable);
    }
}
