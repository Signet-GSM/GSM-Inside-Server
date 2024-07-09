package com.GSM_Inside_Server.domain.board.dto.req;

import com.GSM_Inside_Server.domain.image.dto.req.ImageUrlReqDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class BoardReqDTO {
    private Long gallery;

    private String title;

    private String content;

    private List<ImageUrlReqDTO> images;

    private String name;

    private String password;

}
