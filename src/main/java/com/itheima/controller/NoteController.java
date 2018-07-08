package com.itheima.controller;

import com.itheima.bean.Note;
import com.itheima.bean.User;
import com.itheima.service.NoteService;
import com.itheima.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService service;
    @PostMapping("/publish")
    public String publish(Note note, HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        note.setIpaddress(request.getRemoteAddr());
        note.setNid(UUIDUtils.getId());
        note.setTime(new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(new Date()));
       note.setUsername(user.getUsername());
       service.publish(note);
        return "redirect:/note/bbsindexUI";
    }
    @GetMapping("/bbsindexUI")
    public String bbsindexUI(Model model){
        List<Note> notes = service.findAll();
        model.addAttribute("notes",notes);
        return "bbs_index";

    }
    @GetMapping("/detail")
    public String detail(String nid,Model model){
        Note note = service.findOne(nid);
        model.addAttribute("note",note);
        return "bbs_detail";
    }
}
