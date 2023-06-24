package com.onemorething.layered.menu.application.service;


import com.onemorething.layered.menu.application.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void LogIn(MemberDTO memberDTO) {

        System.out.println("memberDTO = " + memberDTO);

        memberDTO.getUserEmail();
        memberDTO.getUserPwd();
    }



}
