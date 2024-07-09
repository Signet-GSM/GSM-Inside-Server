package com.GSM_Inside_Server.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private final CustomErrorCode errorCode;
    private final String detail;

    public CustomException(CustomErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detail = errorCode.getMessage();
    }

}
