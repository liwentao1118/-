package com.itheima.service.impl;

import com.itheima.bean.Note;
import com.itheima.dao.NoteDao;
import com.itheima.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao dao;
    @Override
    public void publish(Note note) {
        dao.save(note);
    }

    @Override
    public List<Note> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"time");
        return dao.findAll(sort);
    }

    @Override
    public Note findOne(String nid) {
        return dao.findOne(nid);
    }

    @Override
    public Note findLast() {
        return dao.findTopByOrderByTimeDesc();
    }
}
