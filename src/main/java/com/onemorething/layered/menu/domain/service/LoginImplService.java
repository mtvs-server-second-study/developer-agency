package com.onemorething.layered.menu.domain.service;

public class LoginImplService {

    /* 설명. 비밀번호 재확인 로직*/
    public String signUpCheckPassward(String pwd1, String pwd2) {

        String result = "Yes";

        if (!(pwd1.trim().equals(pwd2))) {
            result = "No";
        }
        return result;
    }

    /* 설명. 로그인 아이디 중복 체크
     *   아이디 내부 특수 문자/ 대문자 있는 지 체크
     * */
}
