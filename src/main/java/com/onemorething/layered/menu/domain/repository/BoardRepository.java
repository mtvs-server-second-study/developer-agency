package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Board;
import com.onemorething.layered.menu.domain.aggregate.entity.BoardAndUserAndSkill;

public interface BoardRepository {
    void save(Board board);

    BoardAndUserAndSkill getBoardList();
}
