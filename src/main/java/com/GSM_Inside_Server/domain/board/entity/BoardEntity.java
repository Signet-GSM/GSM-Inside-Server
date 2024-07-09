package com.GSM_Inside_Server.domain.board.entity;

import com.GSM_Inside_Server.domain.comment.entity.CommentEntity;
import com.GSM_Inside_Server.domain.gallery.entity.GalleryEntity;
import com.GSM_Inside_Server.domain.image.entity.ImageEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "gallery_id")
    private GalleryEntity gallery;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<ImageEntity> images;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;


    @Column(nullable = false)
    private boolean isAdmin = false;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int like = 0;

    @Column(nullable = false)
    private int dislike = 0;

    @Column(nullable = false)
    private Long view = 0L;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
