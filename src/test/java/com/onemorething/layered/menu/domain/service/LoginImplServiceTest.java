package com.onemorething.layered.menu.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginImplServiceTest {

    private LoginImplService loginImplService;

    @BeforeEach
    public void setUp() {

        this.loginImplService = new LoginImplService();
    }

    @DisplayName("._외의 특수문자가 이메일 계정에 포함되었을때 오류가 나는지 테스트")
    @Test
    void testValidEmail() {

        String str = "realid#^^@gmail.com";

        String email = loginImplService.validEmail(str);

        Assertions.assertEquals("한글, 대문자, ._외 특수문자가 포함되어 있습니다.", email);

    }

    @DisplayName("대문자가 이메일 계정에 포함되었을때 오류 발생 테스트")
    @Test
    void testValidEmail2() {

        String str = "estaQRrt77@naver.com";

        String email = loginImplService.validEmail(str);

        Assertions.assertEquals("한글, 대문자, ._외 특수문자가 포함되어 있습니다.", email);

    }
  
    @DisplayName("한글을 이메일 계정에 입력하였을때 오류 발생하는지 테스트")
    @Test
    void testValidEmail3() {

        String str = "ㅎㅇ@hanmail.net";

        String email = loginImplService.validEmail(str);

        Assertions.assertEquals("한글,대문자._외 특수문자가 포함되어 있습니다.", email);
    }

    @DisplayName("아무것도 입력하지 않았을때 오류 발생 테스트")
    @Test
    void testValidEmail4() {

        String str = null;

        String email = loginImplService.validEmail(str);

        Assertions.assertEquals("아이디를 입력하세요.", email);
    }

    @DisplayName("이메일 계정이 50자를 초과했을때 오류 발생 테스트")
    @Test
    void testValidEmail5() {

        // given
        String str = "qlekrjjsnbekfjdk12938475ekrngjkanwlektnglckdns178236548ekejgnddjfhfwkejgnsjksejhgb@gmail.com";

        // when
        String email = loginImplService.validEmail(str);
      
        // then
        Assertions.assertEquals("길이를 초과하셨습니다.", email);
    }

    @DisplayName("비밀번호 재확인 일치")
    @Test
    void testSignUpCheckPassward() {

        // given
        String pwd1 = "123456789";
        String pwd2 = "123456789";
        // when
        String result = loginImplService.signUpCheckPassward(pwd1, pwd2);
        // then
        Assertions.assertEquals("Yes", result);
    }
  
    @DisplayName("비밀번호 재확인 불일치")
    @Test
    void testSignUpCheckPassward2() {

        // given
        String pwd1 = "12345678";
        String pwd2 = "123456789";
        // when
        String result = loginImplService.signUpCheckPassward(pwd1, pwd2);
        // then
        Assertions.assertEquals("No", result);
    }
}