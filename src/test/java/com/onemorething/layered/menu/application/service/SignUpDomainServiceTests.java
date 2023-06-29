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
    private ValidService validService;
    private SignUpDomainService signUpDomainService;
    private Exception e;

}
