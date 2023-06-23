package com.onemorething.layered.menu.domain.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class UserLoginService {

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

            result = "한글,대문자,._외 특수문자가 포함되어 있습니다.";

        }

        return result;

    }

    public String signUpValidPhone(String userPhone){

        String patternPhone = "^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$";
        String result; //if 결과에 따른 리턴 > 결과에 따라 String 변수에 값 저장후 변수리턴
        /*
            01로 시작하고 (0,1,6,7,8,9)중 하나의 숫자  - (0~9)중 3개 혹은 4개숫자 - (0~9)중 4개 숫자
         */
        if(userPhone==null){//null값 처리
             result="핸드폰 번호를 입력해 주세요.";
        }else if(!userPhone.matches(patternPhone)){ //패턴과 일치하지 않을경우
             result="정확한 번호를 입력해 주세요.";
        }else{
            result="정상";
        }
        return result;

    }
    public String getPhoneList(String userPhone, List<String> dataPhone){ //입력 폰번호, DB 에서 처리한 DATA 폰번호 LIST        for(String equalPhone :dataPhone){
            //userPhone : 회원가입시 입력받은 전화번호
            //dataPhone : DB에서 LIST 타입으로 뽑아낸 핸드폰 번호
        for(String equalPhone : dataPhone){//리스트의 처음부터 끝까지
               if(userPhone.equals(equalPhone)){
                   //입력번호와 dataId 내의 번호를 equals 연산을 for문을 이용하여 반복
                   //일치할경우 이미 가입된 핸드폰 String 문자열 리턴
                   return "이미 가입된 핸드폰입니다.";
               }
           }
        //일치하는 번호가 있을경우 for문 종료후 정상 문자열 리턴
        return "정상";
    }
  
    public String signUpValidPwd(String userPwd) {

        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W)(?!.*[ㄱ-ㅎㅏ-ㅣ가-힣])(?!.*\\s).{6,20}$");
        Matcher password = pattern.matcher(userPwd);

        String result = "Yes";

        if (!password.find()) {
            result = "비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.";
        }
        return result;

    }

    /* 설명. 비밀번호 재확인 로직*/
    public String signUpCheckPassword(String pwd1, String pwd2) {

        String result = "Yes";

        if (!(pwd1.trim().equals(pwd2))) {
            result = "No";
        }
        return result;
    }
}
