package com.itheima.service;

import com.itheima.bean.Note;

import java.util.List;

public interface NoteService {
    void publish(Note note);

    List<Note> findAll();

    Note findOne(String nid);

    Note findLast();
}
