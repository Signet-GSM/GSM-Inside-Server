package com.GSM_Inside_Server.domain.upload.service;

import com.GSM_Inside_Server.domain.upload.dto.res.UploadResDTO;
import com.GSM_Inside_Server.global.thireparty.aws.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {

    private final S3Service s3Service;

    @Autowired
    public UploadService(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    public UploadResDTO uploadImage(MultipartFile file) throws IOException {
        return UploadResDTO.builder()
                .url(s3Service.s3ImageSave(file))
                .build();

    }
}
