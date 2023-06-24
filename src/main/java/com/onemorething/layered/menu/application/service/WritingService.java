package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.WritingDTO;
import org.springframework.stereotype.Service;

@Service
public class WritingService {

    public void Regist(WritingDTO writingDTO) {
        System.out.println("writingDTO = " + writingDTO);
    }
}
