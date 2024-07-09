package com.GSM_Inside_Server.domain.gallery.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class GalleryReqDTO {

    private String name;

    private String image;

    private String description;

}
