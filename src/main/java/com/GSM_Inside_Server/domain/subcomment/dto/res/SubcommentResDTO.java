package com.GSM_Inside_Server.domain.subcomment.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class SubcommentResDTO {

    private Long id;

    private Long comment;

    private String content;

    private String name;
}
