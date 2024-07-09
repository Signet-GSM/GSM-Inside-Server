package com.GSM_Inside_Server.domain.comment.entity;

import com.GSM_Inside_Server.domain.board.entity.BoardEntity;
import com.GSM_Inside_Server.domain.subcomment.entity.SubcommentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity board;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<SubcommentEntity> subcomment;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    public void update(String content){
        this.content = content;
    }

}
