package com.onemorething.layered.menu.domain.service;

public class LoginImplService {

    public String validEmail(String email) {

        String regExp = "^[a-z0-9_.]+@[a-z0-9.-]+$";

        String result;

        if(email==null){

            result = "아이디를 입력하세요.";

        }else if(email.length()>50){

            result = "길이를 초과하셨습니다.";

        }else if(email.matches(regExp)) {

            result = "정상입력입니다.";

        }else {

            result = "한글,대문자._외 특수문자가 포함되어 있습니다.";

        }

        return result;

    }

    /* 설명. 로그인 아이디 중복 체크
    *   아이디 내부 특수 문자/ 대문자 있는 지 체크
    * */



}
