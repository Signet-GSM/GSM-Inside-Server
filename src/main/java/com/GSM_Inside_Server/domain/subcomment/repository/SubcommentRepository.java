package com.GSM_Inside_Server.domain.subcomment.repository;

import com.GSM_Inside_Server.domain.subcomment.entity.SubcommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcommentRepository extends JpaRepository<SubcommentEntity, Long> {
    List<SubcommentEntity> findAllByCommentId(Long id);
}
