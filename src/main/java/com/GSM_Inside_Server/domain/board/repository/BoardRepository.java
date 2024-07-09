package com.GSM_Inside_Server.domain.board.repository;

import com.GSM_Inside_Server.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findAllByOrderByDate();
    List<BoardEntity> findAllByOrderByLike();
    List<BoardEntity> findAllByOrderByView();
}
