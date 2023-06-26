package com.onemorething.layered.menu.domain.service.login.common;

import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginValidIdTests {

    private ValidService validService;

    private Exception e;

    @BeforeEach
    public void setUp() {
        this.validService = new ValidService();
        this.e = new Exception();
    }

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

}
