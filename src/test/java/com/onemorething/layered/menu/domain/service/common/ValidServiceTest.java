package com.onemorething.layered.menu.domain.service.common;

import com.onemorething.layered.menu.application.dto.BoardDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidServiceTest {
    private ValidService validService;

    @BeforeEach
    public void setUp() {
        validService = new ValidService();
    }

    @DisplayName("올바른 값을 입력했을 때 예외 발생이 안되는지")
    @Test
    public void testValidInput() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Life Quote");
        boardDTO.setThreePoem("Roses are red");
        boardDTO.setSalary(3000);
        boardDTO.setProfile("profile.jpg");
        boardDTO.setGitContribution("contribution.jpg");

        Assertions.assertDoesNotThrow(() -> validService.validateInput(boardDTO));
    }

    @Test
    public void testEmptyTitle() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("");
        boardDTO.setThreePoem("Roses are red");
        boardDTO.setSalary(3000);
        boardDTO.setProfile("profile.jpg");
        boardDTO.setGitContribution("contribution.jpg");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validService.validateInput(boardDTO));

        Assertions.assertEquals("인생 명언을 작성해주세요", exception.getMessage());
    }

    @Test
    public void testEmptyThreePoem() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Life Quote");
        boardDTO.setThreePoem("");
        boardDTO.setSalary(3000);
        boardDTO.setProfile("profile.jpg");
        boardDTO.setGitContribution("contribution.jpg");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validService.validateInput(boardDTO));

        Assertions.assertEquals("삼행시를 작성해주세요", exception.getMessage());
    }

    @Test
    public void testInvalidSalary() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Life Quote");
        boardDTO.setThreePoem("Roses are red");
        boardDTO.setSalary(1500);
        boardDTO.setProfile("profile.jpg");
        boardDTO.setGitContribution("contribution.jpg");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validService.validateInput(boardDTO));

        Assertions.assertEquals("희망 연봉을 입력해주세요. 최소값은 2,000만 원입니다.", exception.getMessage());
    }

    @Test
    public void testEmptyProfile() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Life Quote");
        boardDTO.setThreePoem("Roses are red");
        boardDTO.setSalary(3000);
        boardDTO.setProfile("");
        boardDTO.setGitContribution("contribution.jpg");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validService.validateInput(boardDTO));

        Assertions.assertEquals("프로필 사진을 등록해주세요", exception.getMessage());
    }

    @Test
    public void testEmptyGitContribution() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Life Quote");
        boardDTO.setThreePoem("Roses are red");
        boardDTO.setSalary(3000);
        boardDTO.setProfile("profile.jpg");
        boardDTO.setGitContribution("");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> validService.validateInput(boardDTO));

        Assertions.assertEquals("깃허브 잔디 사진을 등록해주세요", exception.getMessage());
    }
}
