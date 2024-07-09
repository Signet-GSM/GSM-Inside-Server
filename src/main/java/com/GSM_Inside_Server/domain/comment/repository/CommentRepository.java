package com.GSM_Inside_Server.domain.comment.repository;

import com.GSM_Inside_Server.domain.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByBoardId(Long id);
}
