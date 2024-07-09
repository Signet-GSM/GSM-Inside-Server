package com.GSM_Inside_Server.global.thireparty.aws.s3;

import com.GSM_Inside_Server.global.error.CustomException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.GSM_Inside_Server.global.error.CustomErrorCode.INVALID_FILE;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String s3ImageSave(MultipartFile multipartFile) throws IOException {
        final List<String> allowExtension = Arrays.asList("jpg", "jpeg", "png");

        String originalFilename = multipartFile.getOriginalFilename();
        String[] splitFile = originalFilename.toString().split("\\.");

        if (splitFile.length != 2) throw new CustomException(INVALID_FILE);
        if(!allowExtension.contains(splitFile[1].toLowerCase())) throw new CustomException(INVALID_FILE);


        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        amazonS3.putObject(bucket, originalFilename, multipartFile.getInputStream(), metadata);
        return amazonS3.getUrl(bucket, originalFilename).toString();
    }
}
