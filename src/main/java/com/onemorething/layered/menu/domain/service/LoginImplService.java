package com.onemorething.layered.menu.domain.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginImplService {

    public String signUpValidPwd(String userPwd) {

        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W)(?!.*[ㄱ-ㅎㅏ-ㅣ가-힣])(?!.*\\s).{6,20}$");
        Matcher password = pattern.matcher(userPwd);

        String result = "Yes";

        if (!password.find()) {
            result = "비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.";
        }
        return result;

    }

}