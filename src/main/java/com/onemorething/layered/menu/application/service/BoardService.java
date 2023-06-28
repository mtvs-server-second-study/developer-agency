package com.onemorething.layered.menu.application.service;

import com.onemorething.layered.menu.application.dto.BoardDTO;
import com.onemorething.layered.menu.domain.aggregate.entity.Board;
import com.onemorething.layered.menu.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    public void fileUpload(BoardDTO boardDTO) {

        // entity 변환
        Board newBoard = new Board(boardDTO.getUserEmail(), boardDTO.getTitle(), boardDTO.getThreePoem(),
                boardDTO.getSalary(), boardDTO.getProfile(), boardDTO.getGitContribution());

        boardRepository.save(newBoard);
    }
}