package com.onemorething.layered.menu.domain.service.login;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserLogInService {

    public String loginValidEmail(String userEmail) {

        String reqExp = "^[a-z0-9_.]+@[a-z0-9.-]+$";

        if(userEmail == "") {

            throw new NullPointerException("이메일을 입력하세요.");

        } else if(userEmail.length() > 50) {

            throw new IllegalArgumentException("이메일의 길이가 깁니다.");

        } else if (!userEmail.toLowerCase().equals(userEmail)) {

            throw new IllegalArgumentException("이메일에는 대문자를 사용할 수 없습니다.");

        } else if(userEmail.matches(reqExp)) {

            return "정상";

        } else {

            throw new IllegalArgumentException("잘못된 이메일입니다.");
        }

    }

    public String loginValidPwd(String userPwd) {

        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W)(?!.*[ㄱ-ㅎㅏ-ㅣ가-힣])(?!.*\\s).{6,20}$");
        Matcher password = pattern.matcher(userPwd);

        if (!password.find()) {
            throw new IllegalArgumentException("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.");
        }

        return "정상";
    }
}
