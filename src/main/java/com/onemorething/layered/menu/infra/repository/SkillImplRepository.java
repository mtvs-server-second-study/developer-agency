package com.onemorething.layered.menu.infra.repository;

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
//    @Override
//    public int insertSkill(SkillAndTech skillAndTech) {
//        int result=2;
//        for (int i = 0; i< skillAndTech.getUserTech().size(); i++){
//            if (!skillAndTech.getUserTech().get(i).equals("없음")){
//                result = sqlSession.insert("SkillRepository.insertSKill",
//                        new SkillAndTech(skillAndTech.getUserEmail(),
//                                skillAndTech.getUserTech().get(i),
//                                skillAndTech.getProficiency().get(i)) );
//                if (result == 0) {
//                    return result;
//                }
//            }
//        }
//        return result;
//    }
}
