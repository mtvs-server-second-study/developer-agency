package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.application.service.LoginService;
import com.onemorething.layered.menu.application.service.SignUpService;
import com.onemorething.layered.menu.application.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    private final UserMapper userMapper;

    @Autowired
    public AccountController(SignUpService signUpService, LoginService loginService, UserMapper userMapper) {

        this.signUpService = signUpService;
        this.loginService = loginService;
        this.userMapper = userMapper;
    }

    @GetMapping("/signup")
    public void signUpFrom() {
    }
  
    @GetMapping("/signupresult")
    public String signUpResult() {

        return "account/signupresult";
    }

    /* 회원가입에서 입력 값 넘기는 매핑 */
    @PostMapping("/signup")
    public String signUp(@ModelAttribute("userDTO") UserDTO userDTO, RedirectAttributes rttr) {
        try {
            //DTO를 이용한 값 전달 (로직실행), entity로 변환후 DB INSERT
            signUpService.signUp(userDTO);
            //리다이렉트 (회원가입 결과 페이지)
            return "redirect:/account/signupresult";
        } catch (IllegalArgumentException e) {
            //오류 발생시 회원가입 로직에서 에러메시지 를 받아옴
            rttr.addFlashAttribute("message", e.getMessage());

            //회원가입 페이지로  alert 메시지 표출후 리다이렉트
            return "redirect:/account/signup";
        }
    }

    @GetMapping("login")
    public void login() {}

    @PostMapping("/login")
        public String loginMenu(HttpSession session, RedirectAttributes rttr, UserDTO userDTO) {


        // 로그인 처리
        try {
            userDTO = userMapper.toDTO(loginService.LogIn(userDTO));

            // 로그인 성공한 경우 세션에 사용자 정보 저장
            session.setAttribute("userEmail", userDTO.getUserEmail());
            session.setAttribute("userName", userDTO.getUserName());

            // 필요한 경우, 환영 메시지 등을 세션에 저장
            return "redirect:/";

        } catch (IllegalArgumentException e) {

            // 로그인 실패한 경우
            rttr.addFlashAttribute("message", e.getMessage());

            return "redirect:/account/login";
        }
    }

    /* 로그아웃 */
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("findid")
    public void findId() {}

    @PostMapping("findid")
    public String findIdResult(RedirectAttributes rttr, UserDTO userDTO, Model model) {

        try {
            userDTO = userMapper.toDTO(loginService.findId(userDTO));
            String message = userDTO.getUserName() + "님의 id는 " + userDTO.getUserEmail() + "입니다.";
            model.addAttribute("result", message);

            return "/account/findidresult";

        } catch (IllegalArgumentException e) {
            rttr.addFlashAttribute("message", e.getMessage());

            return "redirect:/account/findid";
        }
    }

    @GetMapping("findpassword")
    public void findPwd() {}

    @PostMapping("findpassword")
    public String findPwdResult(RedirectAttributes rttr, UserDTO userDTO, Model model) {

        try {
            userDTO = userMapper.toDTO(loginService.findPwd(userDTO));
            String message = userDTO.getUserName() + "님의 password는 " + userDTO.getUserPwd() + "입니다";
            model.addAttribute("result", message);

            return "/account/findpasswordresult";

        } catch (IllegalArgumentException e) {
            rttr.addFlashAttribute("message", e.getMessage());
        }
            return "redirect:/account/findpassword";
    }

}

