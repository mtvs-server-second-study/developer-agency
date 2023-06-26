package com.onemorething.layered.menu.domain.service.login.signup;

import com.onemorething.layered.menu.domain.service.signup.SignUpValidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SignUpVaildPhoneTests {

    private SignUpValidService signUpValidService;
    private Exception e;

    @BeforeEach
    public void setUp() {
        this.signUpValidService = new SignUpValidService();
        this.e=new Exception();
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
        String result = signUpValidService.checkValidPhone(phone1);

        //then
        Assertions.assertEquals("정상",result);


    }

    @DisplayName("입력받은 핸드폰의 값을 입력하지 않을떄")
    @Test
    public void nullArgument(){ //null값 입력

        //given
        String phone1 = "";

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpValidService.checkValidPhone(phone1)
        );
        System.out.println(e);
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

        //when, then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpValidService.checkValidPhone(phone1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpValidService.checkValidPhone(phone2)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpValidService.checkValidPhone(phone3)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpValidService.checkValidPhone(phone4)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpValidService.checkValidPhone(phone5)
        );
        System.out.println(e);

    }

}
