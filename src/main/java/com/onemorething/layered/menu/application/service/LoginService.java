package com.onemorething.layered.menu.application.service;


import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void LogIn(UserDTO userDTO) {

        System.out.println("memberDTO = " + userDTO);

        userDTO.getUserEmail();
        userDTO.getUserPwd();
    }

    public String findId(UserDTO userDTO) {

        String result = userRepository.findId(new User(userDTO)).getUserEmail();
        if (result==null) {
            return "Not Found";
        }
        return result;
    }

    public String findPwd(UserDTO userDTO) {

        String result = userRepository.findPwd(new User(userDTO)).getUserPwd();
        if (result == null) {
            return "Not Found";
        }
        return result;
    }



}
