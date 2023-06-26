package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.application.service.LoginService;
import com.onemorething.layered.menu.application.service.SignUpService;
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
@SessionAttributes({"userEmail","userPwd"})    // model.attribute()를 쓰기 위한 어노테이션
public class AccountController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @Autowired
    public AccountController(SignUpService signUpService, LoginService loginService) {

        this.signUpService = signUpService;
        this.loginService = loginService;
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

//    @PostMapping("login")
//    public String loginMenu(Model model, RedirectAttributes rttr, @RequestParam String userEmail) {
//
//        //로그인 처리 로직 작성
//
//
//        //로그인 정보 세션에 저장
//        model.addAttribute("userEmail", userEmail);
//        rttr.addFlashAttribute("message", "환영합니다.");
//
//        return "redirect:/";
//    }

    @PostMapping("/login")
    public String loginMenu(HttpSession session, UserDTO userDTO) {
        // 사용자 입력값 가져오기
        String email = userDTO.getUserEmail();
        String name = userDTO.getUserName();

        // 로그인 처리
        if (loginService.LogIn(userDTO)) {
            // 로그인 성공한 경우
            // 세션에 사용자 정보 저장
            System.out.println(email);

            session.setAttribute("userEmail", email);

            // 필요한 경우, 환영 메시지 등을 세션에 저장
            session.setAttribute("message", userDTO.getUserEmail() + "님 환영합니다.");

            return "redirect:/";

        } else {
            // 로그인 실패한 경우


            return "이상해";
        }
    }


            // 로그인 실패한 경우
            // 실패 처리 로직 수행
            // ...

//            return "redirect:/login";
//        // memberDTO 에 값 담기
//        userDTO.setUserEmail(email);
//        userDTO.setUserPwd(pwd);
//
//        //로그인 정보 세션에 저장
////        model.addAttribute("userEmail", userEmail);
////        rttr.addFlashAttribute("message", "환영합니다.");
//
//        // 서비스 호출
//        loginService.LogIn(userDTO);
//
//        // 어떤걸 리턴해야 하는가?
//        return "redirect:/";
//    }

    /* 로그아웃 */
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping("findid")
    public void findId() {}

    @PostMapping("findid")
    public String findIdResult(Model model, UserDTO userDTO) {

        String email = loginService.findId(userDTO);
        String message = userDTO.getUserName() + "님의 id는 " + email + "입니다.";
        model.addAttribute("message", message);

        return "/account/findidresult";
    }

    @GetMapping("findpassword")
    public void findPwd() {}

    @PostMapping("findpassword")
    public String findPwdResult(Model model, UserDTO userDTO) {

        String password = loginService.findPwd(userDTO);
        String message = userDTO.getUserName() + "님의 password는 " + password + "입니다";
        model.addAttribute("message", message);

        return "/account/findpasswordresult";
    }

}

