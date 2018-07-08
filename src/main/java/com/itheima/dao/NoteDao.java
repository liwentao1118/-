package com.itheima.dao;

import com.itheima.bean.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao  extends JpaRepository<Note,String> {
    Note findTopByOrderByTimeDesc();
}
