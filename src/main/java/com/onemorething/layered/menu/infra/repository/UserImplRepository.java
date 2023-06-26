package com.onemorething.layered.menu.infra.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public class UserImplRepository implements UserRepository {

    private final SqlSession sqlSession;

    @Autowired
    public UserImplRepository(@Qualifier("SessionTemplate") SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserList() {
        return sqlSession.selectList("UserRepository.getUserList");
    }

    @Override
    public User findId(User user) {
        return sqlSession.selectOne("UserRepository.findId", user);
    }

    @Override
    public User findPwd(User user) {
        return sqlSession.selectOne("UserRepository.findPwd", user);
    }

    public User logIn(User user) {

        return sqlSession.selectOne("UserRepository.login", user);
      }
  
    public void saveUser(User user) {
        int result = sqlSession.insert("UserRepository.saveUser", user);
        if (result != 1) {//DB에 저장 실패시 0 성공시 1 리턴
            //회원가입 실패 오류처리
            throw new IllegalArgumentException("회원가입 실패, 관리자에게 문의하세요.");
        }
    }

}
