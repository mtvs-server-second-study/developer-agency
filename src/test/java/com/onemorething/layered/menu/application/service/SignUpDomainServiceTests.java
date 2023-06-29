package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.domain.repository.SkillRepository;
import com.onemorething.layered.menu.domain.repository.TechRepository;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import com.onemorething.layered.menu.domain.service.signup.SignUpDomainService;
import org.junit.jupiter.api.BeforeEach;

public class SignUpDomainServiceTests {

    private com.onemorething.layered.menu.application.service.SignUpService signUpService;
    private UserRepository userRepository;
    private SkillRepository skillRepository;
    private TechRepository techRepository;
    // 검증로직 (공통)
    private ValidService validService;
    //검증로직(회원가입용 비밀번호 재입력 검증)
    private SignUpDomainService signUpDomainService;
    private Exception e;

}
