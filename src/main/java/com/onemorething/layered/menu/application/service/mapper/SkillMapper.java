package com.onemorething.layered.menu.application.service.mapper;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.SkillAndTech;

public class SkillMapper {

    public SkillAndTech userDtoToSkill(UserDTO userDTO){
        SkillAndTech skillAndTech = new SkillAndTech();
        skillAndTech.setUserEmail(userDTO.getUserEmail());
        skillAndTech.setUserTech(userDTO.getUserTech());
        skillAndTech.setProficiency(userDTO.getProficiency());
        return skillAndTech;
    }

//    public UserDTO techTouserDto(SkillAndTech skill){
//        UserDTO userDTO = new UserDTO(skill.getUserTech1(),
//                skill.getProficiency1(),
//                skill.getUserTech2(),
//                skill.getProficiency2(),
//                skill.getUserTech3(),
//                skill.getProficiency3());
//        return userDTO;
//    }




}
