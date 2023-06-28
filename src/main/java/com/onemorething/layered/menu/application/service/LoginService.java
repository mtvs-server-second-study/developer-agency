package com.onemorething.layered.menu.application.service;


import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.application.service.mapper.UserMapper;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import com.onemorething.layered.menu.domain.service.signup.SignUpValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final ValidService validService;
    private final UserRepository userRepository;
    private final SignUpValidService signUpValidService;
    private final UserMapper userMapper = new UserMapper();

    @Autowired
    public LoginService(ValidService validService, UserRepository userRepository, SignUpValidService signUpValidService) {
        this.validService = validService;
        this.userRepository = userRepository;
        this.signUpValidService= signUpValidService;
    }

    public User findId(UserDTO userDTO) {

        signUpValidService.checkValidName(userDTO.getUserName());
        signUpValidService.checkValidPhone(userDTO.getUserPhone());

        User user = userMapper.toEntity(userDTO);

        User findUser = userRepository.findId(user);
        if(findUser != null) {
            userDTO.setUserEmail(findUser.getUserEmail());
            userDTO.setUserName(findUser.getUserName());

            return findUser;

        } else {
            throw new IllegalArgumentException("일치하는 정보가 없습니다");
        }
    }

    public User findPwd(UserDTO userDTO) {

        validService.checkValidEmail(userDTO.getUserEmail());
        signUpValidService.checkValidName(userDTO.getUserName());
        signUpValidService.checkValidPhone(userDTO.getUserPhone());

        User user = userMapper.toEntity(userDTO);

        User userInfo = userRepository.findPwd(user);
        if(userInfo != null) {
            userDTO.setUserName(userInfo.getUserName());
            userDTO.setUserPwd(userInfo.getUserPwd());

            return userInfo;

        } else {
            throw new IllegalArgumentException("일치하는 정보가 없습니다.");
        }
    }

    public User LogIn(UserDTO userDTO) {
        validService.checkValidEmail(userDTO.getUserEmail());

        User user = userMapper.toEntity(userDTO);
        User loginUser = userRepository.logIn(user);

        if (loginUser != null) {
            userDTO.setUserEmail(loginUser.getUserEmail());
            userDTO.setUserName(loginUser.getUserName());
            return loginUser;

        } else {
            throw new IllegalArgumentException("로그인 실패하셨습니다.");
        }
    }
}
