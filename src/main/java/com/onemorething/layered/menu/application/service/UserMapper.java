package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserPwd(user.getUserPwd());
        userDTO.setUserBirth(user.getUserBirth());
        userDTO.setUserPhone(user.getUserPhone());
        userDTO.setUserTech1(user.getUserTechStack1());
        userDTO.setUserTech2(user.getUserTechStack2());
        userDTO.setUserTech3(user.getUserTechStack3());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserName(userDTO.getUserName());
        user.setUserPwd(userDTO.getUserPwd());
        user.setUserBirth(userDTO.getUserBirth());
        user.setUserPhone(userDTO.getUserPhone());
        user.setUserTechStack1(userDTO.getUserTech1());
        user.setUserTechStack2(userDTO.getUserTech2());
        user.setUserTechStack3(userDTO.getUserTech3());
        return user;
    }
}