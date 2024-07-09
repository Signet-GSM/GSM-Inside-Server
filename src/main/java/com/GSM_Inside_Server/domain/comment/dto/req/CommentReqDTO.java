package com.GSM_Inside_Server.domain.comment.dto.req;

import lombok.Getter;

@Getter
public class CommentReqDTO {

    private Long board;

    private String name;

    private String password;

    private String content;
}
