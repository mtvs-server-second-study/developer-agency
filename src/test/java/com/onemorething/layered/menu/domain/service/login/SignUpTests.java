package com.onemorething.layered.menu.domain.service.login;

import com.onemorething.layered.menu.domain.service.valid.ValidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SignUpTests {

    private ValidService validService;
    private UserSignUpService userSignUpService;
    private Exception e;
    @BeforeEach
    public void setUp() {
        this.validService = new ValidService();
        this.userSignUpService = new UserSignUpService();
        this.e=new Exception();
    }

    /* 설명. 이메일 유효성 검사 */
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

    /* 설명. 패스워드 유효성 검사 */
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

    /* 설명. 전화번호 유효성 검사 */

    @DisplayName("입력받은 핸드폰의 값이 정상일때 String 리턴값 정상 확인")
    @Test
    public void normalArgument(){

        //given
        String phone1 = "010-1234-5678";

        //when
        String result = validService.checkValidPhone(phone1);

        //then
        Assertions.assertEquals("정상",result);


    }

    @DisplayName("입력받은 핸드폰의 값이 NULL 일때")
    @Test
    public void nullArgument(){ //null값 입력

        //given
        String phone1 = null;

        //when,then
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPhone(phone1)
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
                () -> validService.checkValidPhone(phone1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPhone(phone2)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPhone(phone3)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPhone(phone4)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validService.checkValidPhone(phone5)
        );
        System.out.println(e);
    }

    /* 설명. 비밀번호 재확인 */

    @DisplayName("비밀번호 재확인 일치")
    @Test
    void testSignUpCheckPassword() {

        // given
        String pwd1 = "123456789";
        String pwd2 = "123456789";
        // when
        String result = userSignUpService.signUpCheckPwd(pwd1, pwd2);
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
                () -> userSignUpService.signUpCheckPwd(pwd1,pwd2)
        );
        System.out.println(e);
    }
}