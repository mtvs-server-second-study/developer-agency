package com.onemorething.layered.menu.domain.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SignUpValidPwdTests {

    UserLoginService loginImplService;

    @BeforeEach
    public void setUp() {
        this.loginImplService = new UserLoginService();
    }
    @DisplayName("비밀번호를 숫자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"111111", "123456", "1234567890"})
    public void numberPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 알파벳으로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdafgfg", "qwewqrgdsg", "asfdgthyjgf"})
    public void alphabetPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 5자만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc1!", "def2@", "ghi3#"})
    public void fourPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 21자 이상 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcdefghijk12345678910!!!", "lmnopqrstuvwxyz123456789@@@@@@@"})
    public void twentytwoPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 한글로 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"한글이지롱요", "ㄱㄴㄷㄹㅁㅂ","ㅏㅑㅓㅕㅗㅛ"})
    public void koreaPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호에 공백이 들어간 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc de123!", "a bcde123!", "ab ced123!"})
    public void blankPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 숫자와 알파벳만으로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcde123", "fghij456", "klmno789"})
    public void numberAndAlphabetPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 알파벳과 특수문자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abced!@#", "efghi$%^", "jklmn&*("})
    public void alpahbetAndPatternPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 숫자와 특수문자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12345!@#$","67890$^%$","1234$%^&"})
    public void numberAndPatternPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("비밀번호는 최소 6자 이상 최대 20자 이하여야하며, 알파벳, 숫자, 특수문자가 포함되어야 합니다.", result);
    }

    @DisplayName("비밀번호를 최소 6자 이상 최대 20자 이하, 알파벳, 숫자, 특수문자가 포함하게 잘 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test1234!@#$", "apple5678!@#$", "asd12!"})
    public void goodPwd(String pwd) {
        // when
        String result = loginImplService.signUpValidPwd(pwd);
        // then
        Assertions.assertEquals("Yes", result);
    }
}



