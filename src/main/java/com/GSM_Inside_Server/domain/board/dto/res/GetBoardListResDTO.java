package com.GSM_Inside_Server.domain.board.dto.res;

import com.GSM_Inside_Server.domain.image.entity.ImageEntity;
import com.GSM_Inside_Server.domain.gallery.entity.GalleryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class GetBoardListResDTO {

    private Long id;

    private GalleryEntity gallery;

    private String title;

    private ImageEntity image;

    private String name;

    private int like;

}
