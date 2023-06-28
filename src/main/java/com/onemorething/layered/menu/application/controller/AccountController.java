package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.application.service.LoginService;
import com.onemorething.layered.menu.application.service.SignUpService;
import com.onemorething.layered.menu.application.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    private final UserMapper userMapper = new UserMapper();

    @Autowired
    public AccountController(SignUpService signUpService, LoginService loginService) {

        this.signUpService = signUpService;
        this.loginService = loginService;
    }

    @GetMapping("/signup")
    public String signUpFrom(Model model) {

        model.addAttribute("techList", signUpService.getTechList());

        return "account/signup";
    }
  
    @GetMapping("/signupresult")
    public String signUpResult() {

        return "account/signupresult";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("userDTO") UserDTO userDTO, HttpSession session, RedirectAttributes rttr, Model model) {
        try {

            signUpService.signUp(userDTO);

            return "redirect:/account/signupresult";
        } catch (IllegalArgumentException e) {

            model.addAttribute("techList", signUpService.getTechList());
            rttr.addFlashAttribute("message", e.getMessage());

            return "redirect:/account/signup";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/checkEmailButton", method = RequestMethod.POST)
    public String checkEmailButton(@RequestBody UserDTO userDTO) {

        try {
            int result = signUpService.checkEmail(userDTO);

            if (result == 1) {
                return "1";
            } else {
                return "0";
            }
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }
    @GetMapping("login")
    public void login() {}

    @PostMapping("/login")
        public String loginMenu(HttpSession session, RedirectAttributes rttr, UserDTO userDTO) {

        try {
            userDTO = userMapper.toDTO(loginService.LogIn(userDTO));

            session.setAttribute("userEmail", userDTO.getUserEmail());
            session.setAttribute("userName", userDTO.getUserName());

            return "redirect:/";

        } catch (IllegalArgumentException e) {

            rttr.addFlashAttribute("message", e.getMessage());

            return "redirect:/account/login";
        }
    }

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

