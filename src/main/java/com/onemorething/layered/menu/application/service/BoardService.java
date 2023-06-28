package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.BoardDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.Board;
import com.onemorething.layered.menu.domain.repository.BoardRepository;
import com.onemorething.layered.menu.domain.service.common.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ValidService validService;

    @Autowired
    public BoardService(BoardRepository boardRepository,
                        ValidService validService) {
        this.boardRepository = boardRepository;
        this.validService = validService;
    }
  
    public void fileUpload(BoardDTO boardDTO) {
        validService.validateInput(boardDTO);
        Board newBoard = new Board(boardDTO.getUserEmail(), boardDTO.getTitle(), boardDTO.getThreePoem(),
                boardDTO.getSalary(), boardDTO.getProfile(), boardDTO.getGitContribution());

        boardRepository.save(newBoard);
    }
}
