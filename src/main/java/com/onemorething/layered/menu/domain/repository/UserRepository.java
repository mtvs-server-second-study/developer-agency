package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user); //회원가입에 이용할 saveUser 정의

    public List<User> getUserList();

    User logIn(User user);
}
