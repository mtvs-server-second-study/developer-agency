package com.onemorething.layered.menu.domain.service.login.common;

import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SignUpValidPwdTests {

    private ValidService validService;
    private Exception e;

    @BeforeEach
    public void setUp() {
        this.validService = new ValidService();
        this.e=new Exception();
    }

    @DisplayName("비밀번호를 숫자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"111111", "123456", "1234567890"}) //given
    public void numberPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 알파벳으로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdafgfg", "qwewqrgdsg", "asfdgthyjgf"})//given
    public void alphabetPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 5자만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc1!", "def2@", "ghi3#"})//given
    public void fourPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);
        // then

    }

    @DisplayName("비밀번호를 21자 이상 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcdefghijk12345678910!!!", "lmnopqrstuvwxyz123456789@@@@@@@"})//given
    public void twentytwoPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 한글로 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"한글이지롱요", "ㄱㄴㄷㄹㅁㅂ","ㅏㅑㅓㅕㅗㅛ"})//given
    public void koreaPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호에 공백이 들어간 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc de123!", "a bcde123!", "ab ced123!"})//given
    public void blankPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 숫자와 알파벳만으로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcde123", "fghij456", "klmno789"})//given
    public void numberAndAlphabetPwd(String pwd) {
        // when, then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 알파벳과 특수문자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abced!@#", "efghi$%^", "jklmn&*("}) //given
    public void alpahbetAndPatternPwd(String pwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 숫자와 특수문자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12345!@#$","67890$^%$","1234$%^&"}) //given
    public void numberAndPatternPwd(String pwd) {
        // when, then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(pwd)
        );
        System.out.println(e);
    }

    @DisplayName("비밀번호를 최소 6자 이상 최대 20자 이하, 알파벳, 숫자, 특수문자가 포함하게 잘 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test1234!@#$", "apple5678!@#$", "asd12!"}) //given
    public void goodPwd(String pwd) {
        // when
        String result = validService.checkValidPwd(pwd);
        // then
        Assertions.assertEquals("정상", result);
    }
}



