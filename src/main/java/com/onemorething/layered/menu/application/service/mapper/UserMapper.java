package com.onemorething.layered.menu.application.service.mapper;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;

public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserPwd(user.getUserPwd());
        userDTO.setUserBirth(user.getUserBirth());
        userDTO.setUserPhone(user.getUserPhone());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserName(userDTO.getUserName());
        user.setUserPwd(userDTO.getUserPwd());
        user.setUserBirth(userDTO.getUserBirth());
        user.setUserPhone(userDTO.getUserPhone());
        return user;
    }

}
