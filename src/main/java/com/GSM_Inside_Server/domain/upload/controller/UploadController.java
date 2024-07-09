package com.GSM_Inside_Server.domain.upload.controller;

import com.GSM_Inside_Server.domain.upload.dto.res.UploadResDTO;
import com.GSM_Inside_Server.domain.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/")
    public ResponseEntity<UploadResDTO> uploadImage(MultipartFile file) throws IOException {
        return new ResponseEntity<>(uploadService.uploadImage(file), HttpStatus.OK);
    }
}
