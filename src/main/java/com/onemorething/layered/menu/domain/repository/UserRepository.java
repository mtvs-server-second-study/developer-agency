package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.User;

import java.util.List;

public interface UserRepository {

    public List<User> getUserList();
}
