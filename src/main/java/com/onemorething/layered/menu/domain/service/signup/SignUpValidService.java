package com.onemorething.layered.menu.domain.service.signup;


import org.springframework.stereotype.Service;

@Service
public class SignUpValidService {

    public String checkValidName(String userName) {

        String pattern1 = "^[가-힣]{2,30}$";

        if(userName == "") {

            throw new IllegalArgumentException("이름을 입력하세요.");

        } else if(userName.length() > 20) {

            throw new IllegalArgumentException("이릅의 길이가 깁니다.");

        } else if(userName.matches(pattern1)) {

            return "정상";

        } else {

            throw new IllegalArgumentException("잘못된 이름입니다.");
        }

    }
    public String checkValidPhone(String userPhone) {

        String patternPhone = "^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$";
        /*
            01로 시작하고 (0,1,6,7,8,9)중 하나의 숫자  - (0~9)중 3개 혹은 4개숫자 - (0~9)중 4개 숫자
         */
        if (userPhone == "" || userPhone == null) {//null값 처리
            throw new IllegalArgumentException("핸드폰 번호를 입력해 주세요.");
        } else if (!userPhone.matches(patternPhone)) { //패턴과 일치하지 않을경우
            throw new IllegalArgumentException("정확한 핸드폰 번호를 입력해 주세요.");
        } else {
            return "정상";
        }
    }

    /* 설명. 비밀번호 재확인 로직*/
    public String checkPwd(String pwd1, String pwd2) {

        if (!(pwd1.trim().equals(pwd2))) {
            throw new IllegalArgumentException("입력한 비밀번호가 일치하지 않습니다.");
        }
        return "정상";
    }



}
