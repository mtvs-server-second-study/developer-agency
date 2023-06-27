package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Board;

public interface BoardRepository {

    void save(Board board);
}
