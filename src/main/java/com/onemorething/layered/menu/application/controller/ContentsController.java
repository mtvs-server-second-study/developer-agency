package com.onemorething.layered.menu.application.controller;

import com.onemorething.layered.menu.application.dto.BoardDTO;
import com.onemorething.layered.menu.application.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/contents/*")
public class ContentsController {

    private BoardService boardService;

    @Autowired
    public ContentsController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("board")
    public void board() {}

    @PostMapping("board-result")
    public String fileUpload(@RequestParam MultipartFile profile,
                             @RequestParam int salary,
                             @RequestParam String title,
                             @RequestParam String threePoem,
                             @RequestParam("git-contribution") MultipartFile gitContribution,
                             Model model,
                             HttpSession session) {
//        최종 병합 시 삭제
//        System.out.println("profile = " + profile);
//        System.out.println("salary = " + salary);
//        System.out.println("title = " + title);
//        System.out.println("threePoem = " + threePoem);
//        System.out.println("gitContribution = " + gitContribution);


        String root = System.getProperty("user.dir");   // 현재 실행 중인 파일의 작업 디렉토리를 가져옴
        String filePath = root + "/profileImg";
        String filePath2 = root + "/gitContribution";

        // 파일 저장 객체 생성
        File dir = new File(filePath);
        File dir2 = new File(filePath2);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!dir2.exists()) {
            dir2.mkdirs();
        }

        String originFileName = profile.getOriginalFilename();
        String originFileName2 = gitContribution.getOriginalFilename();
//        System.out.println("originFileName = " + originFileName);
//        System.out.println("originFileName2 = " + originFileName2);

        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
//        System.out.println("ext = " + ext);
//        System.out.println("ext2 = " + ext2);

        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
        String savedName2 = UUID.randomUUID().toString().replaceAll("-", "") + ext2;

        String path = filePath + "/" + savedName;
        String path2 = filePath2 + "/" + savedName2;

        try {
            profile.transferTo(new File(path));
            gitContribution.transferTo(new File(path2));
            model.addAttribute("message", "게시글이 저장 되었습니다.");

            BoardDTO boardDTO = new BoardDTO((String) session.getAttribute("userEmail"), title, threePoem, salary, path, path2);

            boardService.fileUpload(boardDTO);

        } catch (IOException e) {
            new File(path).delete();
            new File(path2).delete();

            model.addAttribute("message", "게시글을 저장하지 못했습니다.");
        }

        return "contents/result";
    }

    @GetMapping("detail")
    public void detail() {}
}
