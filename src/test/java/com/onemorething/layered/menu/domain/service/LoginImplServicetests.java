package com.onemorething.layered.menu.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class LoginImplServicetests {

    private LoginImplService loginImplService;
    private List<String> dataPhone1;
    private List<String> dataPhone2;


    @BeforeEach
    public void setUp() {
        this.loginImplService = new LoginImplService();

        this.dataPhone1 = new ArrayList<String>();
        this.dataPhone2 = new ArrayList<String>();
    }
    //검증내용
    //1. 입력받은 핸드폰의 값이 정상일때 String 값 "정상"리턴
    //2. null값 입력시
    //3. 정규표현식과 맞지 않는 값일때
    //4. 입력받은 String , List<String> 값 비교

    @DisplayName("입력받은 핸드폰의 값이 정상일때 String 리턴값 정상 확인")
    @Test
    public void normalArgument(){

        //given
        String phone1 = "010-1234-5678";

        //when
        String result = loginImplService.signUpValidPhone(phone1);

        //then
        Assertions.assertEquals("정상",result);
    }

    @DisplayName("입력받은 핸드폰의 값이 NULL 일때")
    @Test
    public void nullArgument(){ //null값 입력

        //given
        String phone1 = null;

        //when
        String result = loginImplService.signUpValidPhone(phone1);

        //then
        Assertions.assertEquals("핸드폰 번호를 입력해 주세요.",result);
    }

    @DisplayName("정규표현식과 맞지않는 값일때")
    @Test
    public void validFailArgument(){ //정규표현식과 맞지 않을때

        //given
        String phone1 = "014-123-4567"; // 제일 앞자리가 014
        String phone2 = "010-1111-22222"; //뒷자리가 5자
        String phone3 = "010-1234-567A";//문자열 포함
        String phone4 = "01012345678";//하이픈 없음
        String phone5 = "010-1234-56 8";//공백 포함

        //when
        String result1 = loginImplService.signUpValidPhone(phone1);
        String result2 = loginImplService.signUpValidPhone(phone2);
        String result3 = loginImplService.signUpValidPhone(phone3);
        String result4 = loginImplService.signUpValidPhone(phone4);
        String result5 = loginImplService.signUpValidPhone(phone5);

        //then
        Assertions.assertEquals("정확한 번호를 입력해 주세요.",result1);
        Assertions.assertEquals("정확한 번호를 입력해 주세요.",result2);
        Assertions.assertEquals("정확한 번호를 입력해 주세요.",result3);
        Assertions.assertEquals("정확한 번호를 입력해 주세요.",result4);
        Assertions.assertEquals("정확한 번호를 입력해 주세요.",result5);
    }
    @DisplayName("LIST<String>의 폰번호와 입력 폰번호 비교")
    @Test
    public void equalsArgument(){ //null값 입력

        //given
        String phone1 = "010-1234-5678";
        //dataPhone1 같은 폰번호 없는 List
        dataPhone1.add("010-1234-5679");
        dataPhone1.add("010-1234-5677");
        //dataPhone2 같은 폰번호 있는 List
        dataPhone2.add("010-1234-5677");
        dataPhone2.add("010-1234-5678");

        //when
        String result1 = loginImplService.getPhoneList(phone1,dataPhone1);
        String result2 = loginImplService.getPhoneList(phone1,dataPhone2);

        //then
        Assertions.assertEquals("정상",result1);
        Assertions.assertEquals("이미 가입된 핸드폰입니다.",result2);
    }
}
