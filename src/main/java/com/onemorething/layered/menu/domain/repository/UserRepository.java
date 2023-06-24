package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Member;

import java.util.List;

public interface UserRepository {

    public List<Member> getPhoneList();
}
