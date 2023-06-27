package com.onemorething.layered.menu.infra.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Tech;
import com.onemorething.layered.menu.domain.repository.TechRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public class TechImplRepository implements TechRepository {

    private final SqlSession sqlSession;

    @Autowired
    public TechImplRepository(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Tech> getTechList() {
        return sqlSession.selectList("TechRepository.getTechList");
    }
}
