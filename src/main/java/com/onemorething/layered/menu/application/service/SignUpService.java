package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.MemberDTO;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {

    // repo 의존성 주입하기
    private final UserSignUpService userSignUpService;
    private final UserRepository userRepository;

    @Autowired
    public SignUpService(UserSignUpService userSignUpService, UserRepository userRepository) {

        this.userSignUpService = userSignUpService;
        this.userRepository = userRepository;
    }

    /* 회원가입 로직 */
    public List<String> SignUp(MemberDTO memberDTO) {

        System.out.println("memberDTO = " + memberDTO);

        //검증로직
        userSignUpService.validEmail(memberDTO.getUserEmail());
        userSignUpService.signUpValidPwd(memberDTO.getUserPwd());
        userSignUpService.signUpCheckPassword(memberDTO.getUserPwd() ,memberDTO.getUserCheckPwd());
        userSignUpService.signUpValidPhone(memberDTO.getUserPhone());
        userSignUpService.signUpValidPhone(memberDTO.getUserPhone());

        // eneity 변환
        return null;
        // repo 호출하여 저장
    }
}
