package com.onemorething.layered.menu.application.service;


import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.login.UserLogInService;
import com.onemorething.layered.menu.infra.repository.UserImplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    //repo 의존성 주입
    private final UserLogInService userLogInService;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserLogInService userLogInService, UserRepository userRepository) {

        this.userLogInService = userLogInService;
        this.userRepository = userRepository;
    }

    public String findId(UserDTO userDTO) {

        /* 설명. 빈칸 확인 및 유효성 검증 */
        /* 설명. 아이디 찾기 결과 */
        String result = userRepository.findId(new User(userDTO)).getUserEmail();
        if (result==null) {
            return "Not Found";
        }
        return result;
    }

    public String findPwd(UserDTO userDTO) {

        String result = userRepository.findPwd(new User(userDTO)).getUserPwd();
        if (result == null) {
            return "Not Found";
        }
        return result;
    }

    //로그인 로직
    public boolean LogIn(UserDTO userDTO) {
        // 검증로직
        userLogInService.loginValidEmail(userDTO.getUserEmail());
        userLogInService.loginValidPwd(userDTO.getUserPwd());

        // UserDTO -> User(entity) 변환
        User user = new User(userDTO);

        // UserRepository 호출하여 저장
        User loginUser = userRepository.logIn(user);
        System.out.println("loginUser = " + loginUser);
        // 등록된 유저면 로그인 성공으로 간주
        if (loginUser != null) {
            userDTO.setUserEmail(loginUser.getUserEmail());
            return true;
        } else {
            return false;
        }
    }
}
