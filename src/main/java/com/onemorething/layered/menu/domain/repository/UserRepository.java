package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {

    void saveUser(User user); // 필기. 회원가입에 이용할 saveUser 정의
    int checkEmail(User user); // 필기. 중복조회에 이용할 checkEmail 정의

    List<User> getUserList();
    User findId(User user);
    User findPwd(User user);
    User logIn(User user);
}
