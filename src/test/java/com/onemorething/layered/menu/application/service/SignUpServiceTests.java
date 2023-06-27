package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.enumtype.Proficiency;
import com.onemorething.layered.menu.domain.repository.SkillRepository;
import com.onemorething.layered.menu.domain.repository.TechRepository;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import com.onemorething.layered.menu.domain.service.signup.SignUpValidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.onemorething.layered.menu.domain.aggregate.enumtype.Proficiency.*;

public class SignUpServiceTests {

    private SignUpService signUpService;
    private UserRepository userRepository;
    private SkillRepository skillRepository;
    private TechRepository techRepository;
    // 검증로직 (공통)
    private ValidService validService;
    //검증로직(회원가입용 비밀번호 재입력 검증)
    private SignUpValidService signUpValidService;
    private Exception e;

    @BeforeEach
    public void setUp() {
        this.signUpService = new SignUpService(validService, userRepository,
                signUpValidService, skillRepository, techRepository);
        this.e = new Exception();
    }

//    @DisplayName("세 가지 모두 기본 값을 선택했을 때 회원가입이 정상으로 되는 지 확인")
//    @Test
//    void testNoInsertTech(){
//
//        // given
////        List<String> techList = new ArrayList<>( List.of("없음", "없음", "없음"));
////        List<Proficiency> proficiencyList = new ArrayList<>( List.of(상, 중, 하));
//        UserDTO userDTO = new UserDTO("abcd@naver.com", "테스트", "!test1234", "!test1234",
//                "2023-05-10", "010-1234-1234",
//                new ArrayList<>( List.of("없음", "없음", "없음")),
//                new ArrayList<>( List.of(상, 중, 하)));
//
//        // when
//        String result = signUpService.signUp(userDTO);
//        System.out.println("result = " + result);
//
//        // then
//        Assertions.assertEquals("정상", result);
//    }
}
