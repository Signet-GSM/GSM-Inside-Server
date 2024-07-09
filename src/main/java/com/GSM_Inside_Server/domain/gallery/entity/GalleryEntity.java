package com.GSM_Inside_Server.domain.gallery.entity;

import com.GSM_Inside_Server.domain.board.entity.BoardEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "gallery")
public class GalleryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "gallery")
    private List<BoardEntity> board;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false, length = 300)
    private String description;

    @Column(nullable = false)
    private Long view = 0L;

    @Column(nullable = false)
    private boolean isActive = false;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();


    public GalleryEntity(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }
}
