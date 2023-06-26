package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.WritingDTO;
import com.onemorething.layered.menu.application.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/contents/*")
public class ContentsController {

    // 게시글 및 상세페이지 관련 service 의존성 주입하기
    private final WritingService writingService;

    @Autowired
    public ContentsController(WritingService writingService) {
        this.writingService = writingService;
    }

    @GetMapping("/writing")
    public void writing() {}

    /* 글쓰기페이지에서 입력 값 넘기는 매핑 */
    @PostMapping("/writing")
    public String writingMenu(Model model, WebRequest request, WritingDTO writingDTO) {

        // 뷰에서 사용자 입력값 WritingDTO에 담기
        writingDTO.setProfile(request.getParameter("profile"));
        writingDTO.setTitle(request.getParameter("title"));
        writingDTO.setContent(request.getParameter("content"));

        // WritingService 호출
        writingService.Regist(writingDTO);

        // 메인페이지로 redirect
        return "redirect:/";
    }
  
    //메인화면에서 상세페이지로 연결
    @GetMapping("detail")
    public void detail() {}
}
