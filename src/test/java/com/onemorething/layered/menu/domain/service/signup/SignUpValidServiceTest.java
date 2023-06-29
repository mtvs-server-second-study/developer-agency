package com.onemorething.layered.menu.domain.service.signup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SignUpValidTechTest {

    private SignUpDomainService signUpDomainService;
    private Exception e;

    @BeforeEach
    public void setUp() {
        this.e = new Exception();
        this.signUpDomainService = new SignUpDomainService();
    }

    @DisplayName("기술스택 정상 작동 확인")
    @Test
    void testCheckDupulicateTech() {

        // given
        List<String> techList = Stream.of("Java", "react", "MuSQL").collect(Collectors.toList());

        // when
        String result = signUpDomainService.checkDuplicateTech(techList);

        // then
        Assertions.assertEquals("정상", result);

    }

    @DisplayName("기술스택 중복 선택 시 예외 발생")
    @Test
    void testDuplicateTech(){

        // given
        List<String> techList = Arrays.asList("Java", "Java", "MySQL");

        // when, then
        e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> signUpDomainService.checkDuplicateTech(techList)
        );
        assertEquals(e.getMessage(), "기술 스택이 중복됩니다.");
    }

    @DisplayName("미선택으로 인한 기본값 중복 시 예외 중복 허용")
    @Test
    void testExceptionDuplication(){

        // given
        List<String> techList = new ArrayList<>( List.of("Java", "없음", "없음"));

        // when
        String result = signUpDomainService.checkDuplicateTech(techList);
        System.out.println(result);

        // then
        Assertions.assertEquals(result, "정상");
    }

}