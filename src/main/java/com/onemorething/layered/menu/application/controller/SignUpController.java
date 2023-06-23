package com.onemorething.layered.menu.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class SignUpController {

    @GetMapping("signup")
    public String signup() {

        return "signup";
    }
}
