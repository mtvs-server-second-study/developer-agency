package com.onemorething.layered.menu.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contents")
public class ContentsController {

    //메인화면에서 상세페이지로 연결
    @GetMapping("detail")
    public String detail() {

        return "/contents/detail";
    }
}
