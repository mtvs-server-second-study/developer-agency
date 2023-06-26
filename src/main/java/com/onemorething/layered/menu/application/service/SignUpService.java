package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.login.UserSignUpService;
import com.onemorething.layered.menu.domain.service.valid.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;

@Service
public class SignUpService {

    // repository
    private final UserRepository userRepository;
    // 검증로직
    private final ValidService validService;

    private final UserSignUpService userSignUpService;

    @Autowired
    public SignUpService(ValidService validService, UserRepository userRepository, UserSignUpService userSignUpService) {
        this.userRepository= userRepository;
        this.validService = validService;
        this.userSignUpService = userSignUpService;
    }

    //회원가입 로직
    public void signUp(UserDTO userDTO) {

        //검증로직 호출
        validService.checkValidEmail(userDTO.getUserEmail());
        validService.checkValidPwd(userDTO.getUserPwd());
        userSignUpService.signUpCheckPwd(userDTO.getUserPwd(), userDTO.getUserCheckPwd());
        validService.checkValidPhone(userDTO.getUserPhone());

        // UserDTO > User(entity) 변환
        User user=new User(userDTO);

        // UserImplRepository 호출하여 저장 (entity 활용)
        userRepository.saveUser(user);
    }
}
