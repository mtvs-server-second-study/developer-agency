package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.MemberDTO;
import com.onemorething.layered.menu.application.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final SignUpService signUpService;

    @Autowired
    public AccountController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/signup")
    public String signUpFrom() {

        return "account/signup";
    }

    /* 회원가입에서 입력 값 넘기는 매핑 */
    @PostMapping("/signup")
    public String signUp(@ModelAttribute("memberDTO") MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        try {
            //DTO를 이용한 값 전달 (로직실행)
            signUpService.SignUp(memberDTO);

            //리다이렉트 (메인페이지)
            return "redirect:/";
        } catch (IllegalArgumentException e){
            //오류 발생시 회원가입 로직에서 에러메시지 를 받아옴
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());

            //회원가입 페이지로  alert 메시지 표출후 리다이렉트
            return "redirect:/account/signup";
        }

    }


    @GetMapping("login")
    public String login() {

        return "account/login";
    }

}
