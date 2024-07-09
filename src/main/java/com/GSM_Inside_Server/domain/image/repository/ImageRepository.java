package com.GSM_Inside_Server.domain.image.repository;

import com.GSM_Inside_Server.domain.image.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    ImageEntity findFirstByBoardId(Long id);
}
