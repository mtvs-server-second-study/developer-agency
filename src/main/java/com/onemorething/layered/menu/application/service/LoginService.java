package com.onemorething.layered.menu.application.service;


import com.onemorething.layered.menu.application.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void LogIn(UserDTO userDTO) {

        System.out.println("memberDTO = " + userDTO);

        userDTO.getUserEmail();
        userDTO.getUserPwd();
    }



}
