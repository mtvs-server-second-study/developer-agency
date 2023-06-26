package com.onemorething.layered.menu.domain.service.login;


import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserSignUpService {


    /* 설명. 비밀번호 재확인 로직*/
    public String signUpCheckPwd(String pwd1, String pwd2) {

        if (!(pwd1.trim().equals(pwd2))) {
            throw new IllegalArgumentException("입력한 비밀번호가 일치하지 않습니다.");
        }
        return "정상";
    }

}
