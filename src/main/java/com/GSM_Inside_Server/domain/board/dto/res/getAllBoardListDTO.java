package com.GSM_Inside_Server.domain.board.dto.res;

import com.GSM_Inside_Server.domain.image.dto.res.ImageUrlResDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class getAllBoardListDTO {

    private Long id;

    private Long gallery;

    private String image;

    private String title;

    private String content;

    private String name;

    private int like;

    private boolean isAdmin;

}
