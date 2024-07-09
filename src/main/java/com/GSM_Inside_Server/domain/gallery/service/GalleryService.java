package com.GSM_Inside_Server.domain.gallery.service;

import com.GSM_Inside_Server.domain.gallery.dto.req.GalleryReqDTO;
import com.GSM_Inside_Server.domain.gallery.dto.res.GalleryResDTO;
import com.GSM_Inside_Server.domain.gallery.entity.GalleryEntity;
import com.GSM_Inside_Server.domain.gallery.repository.GalleryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Transactional
    public List<GalleryResDTO> getGalleryList() {
        return galleryRepository.findByIsActiveTrue()
                .stream()
                .map(g -> new GalleryResDTO(
                    g.getId(),
                        g.getName(),
                        g.getImage(),
                        g.getView(),
                        g.getDate()
                )).toList();
    }

    @Transactional
    public GalleryResDTO uploadGallery(GalleryReqDTO galleryReqDTO) {
        GalleryEntity gallery = galleryRepository.save(new GalleryEntity(
                galleryReqDTO.getName(),
                galleryReqDTO.getImage(),
                galleryReqDTO.getDescription()
                ));

        return new GalleryResDTO(
                gallery.getId(),
                gallery.getName(),
                gallery.getImage(),
                gallery.getView(),
                gallery.getDate()
        );
    }
}
