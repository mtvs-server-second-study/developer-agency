package com.onemorething.layered.menu.infra.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Member;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImplRepository implements UserRepository {

    private final SqlSession sqlSession;

    @Autowired
    public UserImplRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Member> getPhoneList() {
        return sqlSession.selectList("UserRepository.getPhoneList");
    }


}
