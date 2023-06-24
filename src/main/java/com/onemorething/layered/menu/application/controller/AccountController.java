package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.MemberDTO;
import com.onemorething.layered.menu.application.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account/*")
@SessionAttributes({"userEmail","userPwd"})    // model.attribute()를 쓰기 위한 어노테이션
public class AccountController {

    private final SignUpService signUpService;

    @Autowired
    public AccountController(SignUpService signUpService) {

        this.signUpService = signUpService;
    }

    @GetMapping("/signup")
    public String signUp() {

        return "account/signup";
    }

    /* 회원가입에서 입력 값 넘기는 매핑 */
    @PostMapping("/signup")
    public String signUpMenu(Model model, WebRequest request, MemberDTO memberDTO) {
        // 사용자 입력값 변수에 담기
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        String phone = request.getParameter("phone");
        String tech1  = request.getParameter("tech1");

        // memberDTO 에 값 담기
        memberDTO.setUserEmail(email);
        memberDTO.setUserName(name);
        memberDTO.setUserPwd(pwd1);
        memberDTO.setUserCheckPwd(pwd2);
        memberDTO.setUserPhone(phone);
        memberDTO.setUserTech1(tech1);

        // 서비스 호출
        signUpService.SignUp(memberDTO);

        // 어떤걸 리턴해야 하는가?
        return "redirect:/";
    }

    @GetMapping("login")
    public String login() {

        return "account/login";
    }

    @PostMapping("login")
    public String loginMenu(Model model, RedirectAttributes rttr, @RequestParam String userEmail) {

        //로그인 처리 로직 작성

        //로그인 정보 세션에 저장
        model.addAttribute("userEmail", userEmail);
        rttr.addFlashAttribute("message", "환영합니다.");

        return "redirect:/";
    }
}
