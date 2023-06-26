package com.onemorething.layered.menu.application.service;


import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    //검증로직 의존성 주입
    private final ValidService validService;
    //repository 의존성 주입
    private final UserRepository userRepository;
  
    //Mapper 의존성 주입
    private final UserMapper userMapper;

    @Autowired
    public LoginService(ValidService validService, UserRepository userRepository,UserMapper userMapper) {
        this.validService = validService;
        this.userRepository = userRepository;
        this.userMapper=userMapper;
    }

    public String findId(UserDTO userDTO) {

        /* 설명. 빈칸 확인 및 유효성 검증 */
        /* 설명. 아이디 찾기 결과 */
        String result = userRepository.findId(userMapper.toEntity(userDTO)).getUserEmail();
        if (result==null) {
            return "Not Found";
        }
        return result;
    }

    public String findPwd(UserDTO userDTO) {

        String result = userRepository.findPwd(userMapper.toEntity(userDTO)).getUserPwd();
        if (result == null) {
            return "Not Found";
        }
        return result;
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
