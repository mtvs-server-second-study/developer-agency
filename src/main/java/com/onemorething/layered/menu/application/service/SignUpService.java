package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.MemberDTO;
import com.onemorething.layered.menu.domain.service.login.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    // repo 의존성 주입하기
    private final UserSignUpService userSignUpService;

    @Autowired
    public SignUpService(UserSignUpService userSignUpService) {

        this.userSignUpService = userSignUpService;
    }

    /* 회원가입 로직 */
    public void SignUp(MemberDTO memberDTO) {

        //검증로직 호출
        userSignUpService.signupValidEmail(memberDTO.getUserEmail());
        userSignUpService.signUpValidPwd(memberDTO.getUserPwd());
        userSignUpService.signUpCheckPwd(memberDTO.getUserPwd(), memberDTO.getUserCheckPwd());
        userSignUpService.signUpValidPhone(memberDTO.getUserPhone());

            // eneity 변환

            // repo 호출하여 저장

    }
}
