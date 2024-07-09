package com.GSM_Inside_Server.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾지 못했습니다."),
    GALLERY_NOT_FOUND(HttpStatus.NOT_FOUND, "갤러리를 찾지 못했습니다."),
    INVALID_PASSWORD(HttpStatus.FORBIDDEN, "비밀번호가 다릅니다."),
    FILE_UPLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "파일을 업로드 하는 중 에러가 발생하였습니다."),
    INVALID_FILE(HttpStatus.BAD_REQUEST, "잘못된 파일 형식입니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "댓글을 찾지 못했습니다."),
    SUBCOMMNET_NOT_FOUND(HttpStatus.NOT_FOUND, "대댓글을 찾지 못했습니다."),
    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "이미지를 찾지 못했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
