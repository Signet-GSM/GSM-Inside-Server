package com.GSM_Inside_Server.domain.subcomment.dto.req;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubcommentReqDTO {

    private Long comment;

    private String content;

    private String name;

    private String password;
}
