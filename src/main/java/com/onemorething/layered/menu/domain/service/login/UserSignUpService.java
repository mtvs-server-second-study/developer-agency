package com.onemorething.layered.menu.domain.service.login;


import com.onemorething.layered.menu.application.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserSignUpService {

    public String signupValidEmail(String email) {

        String regExp = "^[a-z0-9_.]+@[a-z0-9.-]+$";

        if(email=="" || email == null){

            throw new IllegalArgumentException("이메일을 입력하세요.");

        }else if(email.length()>50){

            throw new IllegalArgumentException("이메일의 길이가 깁니다.");

        }else if(email.matches(regExp)) {

            return"정상";

        }else {

            throw new IllegalArgumentException("잘못된 이메일입니다.");

        }

    }

    public String signUpValidPhone(String userPhone){

        String patternPhone = "^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$";
        /*
            01로 시작하고 (0,1,6,7,8,9)중 하나의 숫자  - (0~9)중 3개 혹은 4개숫자 - (0~9)중 4개 숫자
         */
        if(userPhone==null){//null값 처리
            throw new IllegalArgumentException("핸드폰 번호를 입력해 주세요.");
        }else if(!userPhone.matches(patternPhone)){ //패턴과 일치하지 않을경우
            throw new IllegalArgumentException("정확한 핸드폰 번호를 입력해 주세요.");
        }else{
            return "정상";
        }

    }
  
    public String signUpValidPwd(String userPwd) {

        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W)(?!.*[ㄱ-ㅎㅏ-ㅣ가-힣])(?!.*\\s).{6,20}$");
        Matcher password = pattern.matcher(userPwd);

        if (!password.find()) {
            throw new IllegalArgumentException("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.");
        }
        return "정상";

    }

    /* 설명. 비밀번호 재확인 로직*/
    public String signUpCheckPwd(String pwd1, String pwd2) {

        if (!(pwd1.trim().equals(pwd2))) {
            throw new IllegalArgumentException("입력한 비밀번호가 일치하지 않습니다.");
        }
        return "정상";
    }
}
