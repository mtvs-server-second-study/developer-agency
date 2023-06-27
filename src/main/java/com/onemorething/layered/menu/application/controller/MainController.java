package com.onemorething.layered.menu.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/*")
public class MainController {
    @RequestMapping(value = {"/","/main"})
    public String main() {

        return "main"; //html 이름
    }
}
