package com.GSM_Inside_Server.domain.gallery.repository;

import com.GSM_Inside_Server.domain.gallery.entity.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
    List<GalleryEntity> findByIsActiveTrue();
}
