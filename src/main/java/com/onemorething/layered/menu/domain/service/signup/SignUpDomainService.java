package com.onemorething.layered.menu.domain.service.signup;


import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SignUpDomainService {

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
        if (userPhone == "" || userPhone == null) {//null값 처리
            throw new IllegalArgumentException("핸드폰 번호를 입력해 주세요.");
        } else if (!userPhone.matches(patternPhone)) { //패턴과 일치하지 않을경우
            throw new IllegalArgumentException("정확한 핸드폰 번호를 입력해 주세요.");
        } else {
            return "정상";
        }
    }

    public String checkPwd(String pwd1, String pwd2) {

        if (!(pwd1.trim().equals(pwd2))) {
            throw new IllegalArgumentException("입력한 비밀번호가 일치하지 않습니다.");
        }
        return "정상";
    }

    public String checkDuplicateTech(List<String> list){
        Set<String> set = new HashSet<>();
        list.stream().filter(value -> !value.equals("없음")).forEach( value -> {
            if (!set.add(value)){
                throw new IllegalArgumentException("기술 스택이 중복됩니다.");
            }
        });

        return "정상";
    }

}
