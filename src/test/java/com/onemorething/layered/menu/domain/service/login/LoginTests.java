package com.onemorething.layered.menu.domain.service.login;

import com.onemorething.layered.menu.domain.service.valid.ValidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginTests {

    private ValidService validService;

    private Exception e;

    @BeforeEach
    public void setUp() {
        this.validService = new ValidService();
        this.e = new Exception();
    }

    /* 설명. 이메일 유효성 검사 */
    @DisplayName("이메일에 공백이 있는 경우 IllegalArgumentException 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"nam@ gmail.com", "n am@gmail.com", " nam@gmail.com"})  //given
    public void testValidEmail1(String userEmail) {
        //when, then
        e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(userEmail)
        );

        System.out.println("e = " + e);
    }

    @DisplayName("이메일의 길이가 50자 이상이면 IllegalArgumentException 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiopqwert@gmail.com",
            "asdfqwertgyhujikolpxzzcvbnmghfjdksleoritudhfjgkslqo@gmail.com"}) //given
    public void testValidEmail2(String userEmail) {
        //when, then
        e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(userEmail)
        );

        System.out.println("e = " + e);
    }
    @DisplayName("이메일에 대문자가 포함되면 IllegalArgumentException 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Abcde@gmail.com", "Fghijk@gmail.com", "asfkGF@gamil.com"}) //given
    public void testValidEmail3(String userEmail) {
        //when, then
        e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(userEmail)
        );

        System.out.println("e = " + e);
    }
    @DisplayName("이메일에 ._외의 특수문자가 포함되면 IllegalArgumentException 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcde$%@gmail.com", "sdfas&&^*@gmail.com", "asdasf!@gmail.com"}) //given
    public void testValidEmail4(String userEmail) {
        //when, then
        e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(userEmail)
        );

        System.out.println("e = " + e);
    }
    @DisplayName("이메일에 한글이 포함되면 IllegalArgumentException 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"ㅁㄴㅇㄹ@gmail.com", "aasdㄴ@gmail.com"}) //given
    public void testValidEmail5(String userEmail) {
        //when, then
        e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidEmail(userEmail)
        );

        System.out.println("e = " + e);
    }
    @DisplayName("이메일 정상 입력 시 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"gywjd@gmail.com", "hj@gmail.com", "nam1234@gmail.com"}) //given
    public void testValidEmail6(String userEmail) {
        //when
        String result = validService.checkValidEmail(userEmail);

        // then
        Assertions.assertEquals("정상", result);
    }

    /* 설명. 비밀번호 유효성 검사 */
    @DisplayName("비밀번호를 숫자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"111111", "123456", "1234567890"}) //given
    public void numberPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 알파벳으로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdafgfg", "qwewqrgdsg", "asfdgthyjgf"})//given
    public void alphabetPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 5자만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc1!", "def2@", "ghi3#"})//given
    public void fourPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);
        // then

    }

    @DisplayName("비밀번호를 21자 이상 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcdefghijk12345678910!!!", "lmnopqrstuvwxyz123456789@@@@@@@"})//given
    public void twentytwoPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 한글로 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"한글이지롱요", "ㄱㄴㄷㄹㅁㅂ","ㅏㅑㅓㅕㅗㅛ"})//given
    public void koreaPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호에 공백이 들어간 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc de123!", "a bcde123!", "ab ced123!"})//given
    public void blankPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 숫자와 알파벳만으로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcde123", "fghij456", "klmno789"})//given
    public void numberAndAlphabetPwd(String userPwd) {
        // when, then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 알파벳과 특수문자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abced!@#", "efghi$%^", "jklmn&*("}) //given
    public void alpahbetAndPatternPwd(String userPwd) {
        // when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);

    }

    @DisplayName("비밀번호를 숫자와 특수문자로만 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12345!@#$","67890$^%$","1234$%^&"}) //given
    public void numberAndPatternPwd(String userPwd) {
        // when, then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPwd(userPwd)
        );
        System.out.println(e);
    }

    @DisplayName("비밀번호를 최소 6자 이상 최대 20자 이하, 알파벳, 숫자, 특수문자가 포함하게 잘 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test1234!@#$", "apple5678!@#$", "asd12!"}) //given
    public void goodPwd(String userPwd) {
        // when
        String result = validService.checkValidPwd(userPwd);
        // then
        Assertions.assertEquals("정상", result);
    }

}
