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

    //검증로직 의존성 주입
    private final ValidService validService;
    //repository 의존성 주입
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

        //검증로직 호출
        signUpValidService.checkValidName(userDTO.getUserName());
        signUpValidService.checkValidPhone(userDTO.getUserPhone());

        //entity 변환
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

        //검증로직 호출
        validService.checkValidEmail(userDTO.getUserEmail());
        signUpValidService.checkValidName(userDTO.getUserName());
        signUpValidService.checkValidPhone(userDTO.getUserPhone());

        //entity 변환
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

    //로그인 로직
    public User LogIn(UserDTO userDTO) {
        // 검증로직
        validService.checkValidEmail(userDTO.getUserEmail());

        // UserDTO -> User(entity) 변환
        User user = userMapper.toEntity(userDTO);

        // UserRepository 호출하여 조회
        User loginUser = userRepository.logIn(user);

        // 등록된 유저면 로그인 성공으로 간주
        if (loginUser != null) {
            userDTO.setUserEmail(loginUser.getUserEmail());
            userDTO.setUserName(loginUser.getUserName());
            return loginUser;

        } else {
            throw new IllegalArgumentException("로그인 실패하셨습니다.");
        }
    }
}
