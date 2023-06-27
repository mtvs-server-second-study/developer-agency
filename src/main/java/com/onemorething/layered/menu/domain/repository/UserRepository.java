package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {

    void saveUser(User user); //회원가입에 이용할 saveUser 정의
    int checkEmail(User user); //중복조회에 이용할 checkEmail 정의

    /* 설명. 이용자 명단 전체 조회 */
    List<User> getUserList();

    /* 설명. 아이디 찾기 */
    User findId(User user);
  
    /* 설명. 패스워드 찾기 */
    User findPwd(User user);

    User logIn(User user);
}
