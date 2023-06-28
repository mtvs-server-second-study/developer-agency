package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/*")
public class MainController {

    private final BoardService boardService;

    @Autowired
    public MainController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = {"/","/main"})
    public String main() {

        return "main"; //html 이름
    }

    @GetMapping("/main")
    public String getBoardList() {

        System.out.println(boardService.getBoardList());
        return "main";
    }
}
