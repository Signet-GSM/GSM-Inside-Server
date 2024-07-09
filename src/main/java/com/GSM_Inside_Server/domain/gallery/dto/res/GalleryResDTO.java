package com.GSM_Inside_Server.domain.gallery.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class GalleryResDTO {

    private Long id;

    private String name;

    private String image;

    private Long view;

    private LocalDateTime date;

}
