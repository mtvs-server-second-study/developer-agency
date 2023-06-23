package com.onemorething.layered.menu.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/*")
public class AccountController {

    @GetMapping("signup")
    public String signUp() {

        return "account/signup";
    }
    @GetMapping("login")
    public String login() {


        return "/account/login";
    }
}
