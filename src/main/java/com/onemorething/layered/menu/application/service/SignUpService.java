package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.TechDTO;
import com.onemorething.layered.menu.application.dto.UserDTO;
import com.onemorething.layered.menu.application.service.mapper.SkillMapper;
import com.onemorething.layered.menu.application.service.mapper.UserMapper;
import com.onemorething.layered.menu.domain.aggregate.entity.Skill;
import com.onemorething.layered.menu.domain.aggregate.entity.SkillAndTech;
import com.onemorething.layered.menu.domain.aggregate.entity.Tech;
import com.onemorething.layered.menu.domain.aggregate.entity.User;
import com.onemorething.layered.menu.domain.repository.SkillRepository;
import com.onemorething.layered.menu.domain.repository.TechRepository;
import com.onemorething.layered.menu.domain.repository.UserRepository;
import com.onemorething.layered.menu.domain.service.signup.SignUpValidService;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@Transactional
public class SignUpService {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final TechRepository techRepository;
    private final ValidService validService;
    private final SignUpValidService signUpValidService;
    private final UserMapper userMapper = new UserMapper();
    private final SkillMapper skillMapper = new SkillMapper();


    @Autowired
    public SignUpService(ValidService validService, UserRepository userRepository,
                         SignUpValidService signUpValidService,
                         SkillRepository skillRepository,
                         TechRepository techRepository) {
        this.userRepository= userRepository;
        this.validService = validService;
        this.signUpValidService = signUpValidService;
        this.skillRepository = skillRepository;
        this.techRepository = techRepository;
    }

    public List<String> getTechList(){
        List<Tech> teches = techRepository.getTechList();
        List<String> techList = new ArrayList<>();
        IntStream.range(0, teches.size()).forEach(i -> {
            techList.add(teches.get(i).getTechName());
        });
        techList.add(0,"기술 스택을 선택해주세요.");
        return techList;
    }

    public void signUp(UserDTO userDTO) {

        validService.checkValidPwd(userDTO.getUserPwd());
        signUpValidService.checkPwd(userDTO.getUserPwd(), userDTO.getUserCheckPwd());
        signUpValidService.checkValidName(userDTO.getUserName());
        signUpValidService.checkValidPhone(userDTO.getUserPhone());
        signUpValidService.checkDuplicateTech(userDTO.getUserTech());

        User user=userMapper.toEntity(userDTO);
        List<Skill> skills = skillMapper.userDTOToSkillList(userDTO);

        userRepository.saveUser(user);
        IntStream.range(0, skills.size()).forEach(i->{
            if (!skills.get(i).getUserTech().equals("없음")) {
                skillRepository.insertSkill(skills.get(i));
            }
        });
    }

    public int checkEmail(UserDTO userDTO){
        validService.checkValidEmail(userDTO.getUserEmail());

        User user=userMapper.toEntity(userDTO);

        return userRepository.checkEmail(user);
    }
}
