package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.application.service.mapper.SkillMapper;
import com.onemorething.layered.menu.application.service.mapper.UserMapper;
import com.onemorething.layered.menu.domain.aggregate.entity.SkillAndTech;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.SkillRepository;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.signup.SignUpValidService;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    // repository
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    // 검증로직 (공통)
    private final ValidService validService;
    //검증로직(회원가입용 비밀번호 재입력 검증)
    private final SignUpValidService signUpValidService;
    //매핑 클래스(엔티티/DTO)
    private final UserMapper userMapper = new UserMapper();
    private final SkillMapper skillMapper = new SkillMapper();


    @Autowired
    public SignUpService(ValidService validService, UserRepository userRepository,
                         SignUpValidService signUpValidService,
                         SkillRepository skillRepository) {
        this.userRepository= userRepository;
        this.validService = validService;
        this.signUpValidService = signUpValidService;
        this.skillRepository = skillRepository;
    }

    //회원가입 로직
    public void signUp(UserDTO userDTO) {

        //검증로직 호출
        validService.checkValidEmail(userDTO.getUserEmail());
        validService.checkValidPwd(userDTO.getUserPwd());
        signUpValidService.checkPwd(userDTO.getUserPwd(), userDTO.getUserCheckPwd());
        signUpValidService.checkValidName(userDTO.getUserName());
        signUpValidService.checkValidPhone(userDTO.getUserPhone());
//        signUpValidService.checkDuplicateTech(userDTO.getUserTech());

        // UserDTO > User(entity) 변환
        User user=userMapper.toEntity(userDTO);
        // UserDTO > SkillAndTech(entity) 변환
        SkillAndTech skillAndTech = skillMapper.userDtoToSkill(userDTO);

        // UserImplRepository 호출하여 저장 (entity 활용)
        userRepository.saveUser(user);
//        skillRepository.insertSkill(skillAndTech);
    }
}
