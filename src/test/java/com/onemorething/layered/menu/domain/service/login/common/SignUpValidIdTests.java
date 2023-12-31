package com.onemorething.layered.menu.domain.service.login.common;

import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SignUpValidIdTests {

    private ValidService validService;

    private Exception e;
    @BeforeEach
    public void setUp() {
        this.validService = new ValidService();
        this.e=new Exception();
    }

    @DisplayName("정상 이메일 입력시 테스트")
    @Test
    void testValidEmail0(){

        //given
        String str="hong12@gmail.com";

        //when
        String result= validService.checkValidEmail(str);

        //then
        Assertions.assertEquals("정상",result);
    }

    @DisplayName("._외의 특수문자가 이메일 계정에 포함되었을때 오류가 나는지 테스트")
    @Test
    void testValidEmail() {

        //given
        String str = "realid#^^@gmail.com";

        //when,then

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(str)
        );
        System.out.println(e);

    }

    @DisplayName("대문자가 이메일 계정에 포함되었을때 오류 발생 테스트")
    @Test
    void testValidEmail2() {

        //given
        String str = "estaQRrt77@naver.com";

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(str)
        );
        System.out.println(e);

    }
    @DisplayName("한글을 이메일 계정에 입력하였을때 오류 발생하는지 테스트")
    @Test
    void testValidEmail3() {

        //given
        String str = "ㅎㅇ@hanmail.net";

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(str)
        );
        System.out.println(e);

    }

    @DisplayName("이메일 계정이 50자를 초과했을때 오류 발생 테스트")
    @Test
    void testValidEmail5() {

        //givem
        String str = "qlekrjjsnbekfjdk12938475ekrngjkanwlektnglckdns178236548ekejgnddjfhfwkejgnsjksejhgb@gmail.com";

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(str)
        );
        System.out.println(e);

    }
}