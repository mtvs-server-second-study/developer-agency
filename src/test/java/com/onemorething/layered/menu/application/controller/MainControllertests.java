package com.onemorething.layered.menu.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainControllertests {
    @RequestMapping(value = {"/","/main"})
    public String main() {

        return "main"; //html 이름
    }
}
