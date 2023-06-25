package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {


    /* 설명. 이용자 명단 전체 조회 */
    List<User> getUserList();

    /* 설명. 아이디 찾기*/
    int findId(User user);
}
