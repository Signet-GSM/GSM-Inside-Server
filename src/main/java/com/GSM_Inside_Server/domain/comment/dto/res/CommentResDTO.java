package com.GSM_Inside_Server.domain.comment.dto.res;

import com.GSM_Inside_Server.domain.subcomment.dto.res.SubcommentResDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CommentResDTO {

    private Long id;

    private Long board;

    private String name;

    private String content;

    private List<SubcommentResDTO> subcomments;
}