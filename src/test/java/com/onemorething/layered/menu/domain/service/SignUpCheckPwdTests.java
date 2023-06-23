package com.onemorething.layered.menu.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SignUpCheckPwdTests {

    private UserSignUpService loginImplService;

    @BeforeEach
    public void setUp() {
        this.loginImplService = new UserSignUpService();
    }

    @DisplayName("비밀번호 재확인 일치")
    @Test
    void testSignUpCheckPassword() {

        // given
        String pwd1 = "123456789";
        String pwd2 = "123456789";
        // when
        String result = loginImplService.signUpCheckPassword(pwd1, pwd2);
        // then
        Assertions.assertEquals("Yes", result);
    }
    @DisplayName("비밀번호 재확인 불일치")
    @Test
    void testSignUpCheckPassword2() {

        // given
        String pwd1 = "12345678";
        String pwd2 = "123456789";
        // when
        String result = loginImplService.signUpCheckPassword(pwd1, pwd2);
        // then
        Assertions.assertEquals("No", result);
    }
}