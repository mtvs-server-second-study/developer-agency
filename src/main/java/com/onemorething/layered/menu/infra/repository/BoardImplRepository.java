package com.onemorething.layered.menu.infra.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Board;
import com.onemorething.layered.menu.domain.repository.BoardRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class BoardImplRepository implements BoardRepository {

    private final SqlSession sqlSession;

    @Autowired
    public BoardImplRepository(@Qualifier("SessionTemplate") SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void save(Board board) {

        int result = sqlSession.insert("BoardRepository.save", board);
        if (result != 1) {
            throw new IllegalArgumentException("게시글 등록 실패, 관리자에게 문의하세요.");
        }
    }
}
