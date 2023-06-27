package com.onemorething.layered.menu.infra.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Skill;
import com.onemorething.layered.menu.domain.aggregate.entity.SkillAndTech;
import com.onemorething.layered.menu.domain.repository.SkillRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class SkillImplRepository implements SkillRepository {

    private final SqlSession sqlSession;

    @Autowired
    public SkillImplRepository(@Qualifier("SessionTemplate") SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public int insertSkill(Skill skill) {
        int result = sqlSession.insert("SkillRepository.insertSkill", skill);
        if (result != 1) {
            throw new IllegalArgumentException("기술 스택 주입 실패, 관리자에게 문의하세요.");
        }
        return result;
    }
}
