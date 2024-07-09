package com.GSM_Inside_Server.domain.board.dto.res;

import com.GSM_Inside_Server.domain.comment.dto.res.CommentResDTO;
import com.GSM_Inside_Server.domain.image.dto.res.ImageUrlResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class BoardResDTO {

    private long id;

    private Long gallery;

    private boolean isAdmin;

    private String title;

    private String content;

    private List<ImageUrlResDTO> images;

    private String name;

    private int like;

    private int dislike;

    private long view;

    private List<CommentResDTO> comments;

}
