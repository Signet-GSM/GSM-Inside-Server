package com.GSM_Inside_Server.domain.subcomment.entity;

import com.GSM_Inside_Server.domain.comment.entity.CommentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sub_comment")
public class SubcommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity comment;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    public void update(String content){
        this.content = content;
    }
}
