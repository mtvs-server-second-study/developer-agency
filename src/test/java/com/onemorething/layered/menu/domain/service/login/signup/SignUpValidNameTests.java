package com.onemorething.layered.menu.domain.service.login.signup;

import com.onemorething.layered.menu.domain.service.signup.SignUpDomainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SignUpValidNameTests {

    private SignUpDomainService signUpDomainService;
    private Exception e;

    @BeforeEach
    public void setUp() {
        this.signUpDomainService = new SignUpDomainService();
        this.e=new Exception();
    }
    //검증내용
    //1. 정상적인 이름값일때
    //2. 값을 입력하지 않았을때
    //3. 이름의 길이가 20자 이상이거나, 1글자 일때
    //4. 정규표현식과 맞지 않는 값일때 (자모음만, 영어 X)

    @DisplayName("정상적인 이름값일때")
    @Test
    public void normalArgument(){

        //given
        String userName1 = "홍길동";

        //when
        String result = signUpDomainService.checkValidName(userName1);

        //then
        Assertions.assertEquals("정상",result);


    }

    @DisplayName("값을 입력하지 않았을때")
    @Test
    public void nullArgument(){

        //given
        String userName1 = "";

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkValidName(userName1)
        );
        System.out.println(e);
    }

    @DisplayName("이름의 길이가 20자 이상이거나, 1글자 일때")
    @Test
    public void lengthArgument(){

        //given
        String userName1 = "동해물과백두산이마르고닳도록하느님이보우하사우리나라만세";
        String userName2 = "무";

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkValidName(userName1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkValidName(userName2)
        );
        System.out.println(e);
    }
    @DisplayName("정규표현식과 맞지 않는 값일때 (자모음만, 영어 X, 숫자 X)")
    @Test
    public void validFailArgument(){ //정규표현식과 맞지 않을때

        //given
        String userName1 = "홍길도ㅇ"; // 제일 앞자리가 014
        String userName2 = "홍길동s"; //뒷자리가 5자
        String userName3 = "홍길동1";//문자열 포함


        //when, then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkValidName(userName1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkValidName(userName2)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkValidName(userName3)
        );
        System.out.println(e);


    }
}
