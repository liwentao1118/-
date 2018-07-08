package com.itheima.controller;

import com.itheima.bean.Ballhistory;
import com.itheima.bean.Note;
import com.itheima.service.HistoryService;
import com.itheima.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HistoryballController {
    @Autowired
    private HistoryService service;
    @Autowired
    private NoteService noteService;
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0") int pageNum){
        List<Ballhistory> ballhistoryList = service.findAll();

        Pageable pageable = new PageRequest(pageNum,10,new Sort(Sort.Direction.DESC,"code"));
        Page<Ballhistory> page = service.findAll(pageable);
        List<Ballhistory> ballhistoryList1 = page.getContent();
        model.addAttribute("historyList",ballhistoryList1);
        model.addAttribute("pages",page);
        Note note = noteService.findLast();
        model.addAttribute("lastnote",note);
        return "index";
    }

    @GetMapping("details")
    public String detail(Model model,String code){
        Ballhistory balltail = service.findOne(code);
        model.addAttribute("history",balltail);
        return "detail";
    }
}
