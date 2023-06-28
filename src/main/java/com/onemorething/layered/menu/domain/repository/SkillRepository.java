package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Skill;
import com.onemorething.layered.menu.domain.aggregate.entity.SkillAndTech;
import org.springframework.stereotype.Component;

@Component
public interface SkillRepository {
    int insertSkill(Skill skill);
}
