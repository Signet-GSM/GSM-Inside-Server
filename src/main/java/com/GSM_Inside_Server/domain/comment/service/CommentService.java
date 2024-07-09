package com.GSM_Inside_Server.domain.comment.service;

import com.GSM_Inside_Server.domain.board.repository.BoardRepository;
import com.GSM_Inside_Server.domain.comment.dto.req.CommentReqDTO;
import com.GSM_Inside_Server.domain.comment.dto.res.CommentResDTO;
import com.GSM_Inside_Server.domain.comment.entity.CommentEntity;
import com.GSM_Inside_Server.domain.comment.repository.CommentRepository;
import com.GSM_Inside_Server.domain.subcomment.dto.res.SubcommentResDTO;
import com.GSM_Inside_Server.global.error.CustomException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.GSM_Inside_Server.global.error.CustomErrorCode.COMMENT_NOT_FOUND;
import static com.GSM_Inside_Server.global.error.CustomErrorCode.INVALID_PASSWORD;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, BoardRepository boardRepository) {
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    public CommentResDTO uploadComment(CommentReqDTO dto) {
        CommentEntity comment = commentRepository.save(CommentEntity.builder()
                .board(boardRepository.findById(dto.getBoard())
                        .orElseThrow(() -> new CustomException(COMMENT_NOT_FOUND)))
                .content(dto.getContent())
                .name(dto.getName())
                .password(dto.getPassword())
                .build()
        );

        return CommentResDTO.builder()
                .id(comment.getId())
                .board(comment.getBoard().getId())
                .content(comment.getContent())
                .name(comment.getName())
                .build();
    }

    @Transactional
    public void putComment(Long id, CommentReqDTO dto){
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new CustomException(COMMENT_NOT_FOUND));

        if (!comment.getPassword().equals(dto.getPassword())){
            throw new CustomException(INVALID_PASSWORD);
        }

        comment.update(dto.getContent());

        CommentEntity newComment = commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
