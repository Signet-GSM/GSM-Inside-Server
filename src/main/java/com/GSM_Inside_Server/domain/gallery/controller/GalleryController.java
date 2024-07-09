package com.GSM_Inside_Server.domain.gallery.controller;

import com.GSM_Inside_Server.domain.gallery.dto.req.GalleryReqDTO;
import com.GSM_Inside_Server.domain.gallery.dto.res.GalleryResDTO;
import com.GSM_Inside_Server.domain.gallery.service.GalleryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService galleryService;

    @Autowired
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<GalleryResDTO>> getGalleryList() {
        return new ResponseEntity<>(galleryService.getGalleryList(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GalleryResDTO> createGallery(@RequestBody GalleryReqDTO galleryReqDTO) {
        return new ResponseEntity<>(galleryService.uploadGallery(galleryReqDTO), HttpStatus.CREATED);
    }


}
