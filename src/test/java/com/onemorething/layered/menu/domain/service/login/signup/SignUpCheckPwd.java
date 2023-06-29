package com.onemorething.layered.menu.domain.service.login.signup;

import com.onemorething.layered.menu.domain.service.signup.SignUpDomainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SignUpCheckPwd {

    private SignUpDomainService signUpDomainService;
    private Exception e;

    @BeforeEach
    public void setUp() {
        this.e=new Exception();
        this.signUpDomainService = new SignUpDomainService();
    }

    @DisplayName("비밀번호 재확인 일치")
    @Test
    void testSignUpCheckPassword() {

        // given
        String pwd1 = "123456789";
        String pwd2 = "123456789";
        // when
        String result = signUpDomainService.checkPwd(pwd1, pwd2);
        // then
        Assertions.assertEquals("정상", result);
    }
    @DisplayName("비밀번호 재확인 불일치")
    @Test
    void testSignUpCheckPassword2() {

        // given
        String pwd1 = "12345678";
        String pwd2 = "123456789";
        // when ,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkPwd(pwd1,pwd2)
        );
        System.out.println(e);
    }
}