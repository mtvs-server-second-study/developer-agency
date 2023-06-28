package com.onemorething.layered.menu.application.service.mapper;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.Skill;
import com.onemorething.layered.menu.domain.aggregate.entity.SkillAndTech;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SkillMapper {

    public List<Skill> userDTOToSkillList(UserDTO userDTO){
        List<Skill> skills = new ArrayList<>();
        IntStream.range(0, userDTO.getUserTech().size()).forEach(index -> {
            Skill skill = new Skill(userDTO.getUserEmail(),
                    userDTO.getUserTech().get(index),
                    userDTO.getProficiency().get(index));
            skills.add(skill);
        });
        return skills;
    }
    public SkillAndTech userDtoToSkillAndTech(UserDTO userDTO){
        SkillAndTech skillAndTech = new SkillAndTech();
        skillAndTech.setUserEmail(userDTO.getUserEmail());
        skillAndTech.setUserTech(userDTO.getUserTech());
        skillAndTech.setProficiency(userDTO.getProficiency());
        return skillAndTech;
    }

}
