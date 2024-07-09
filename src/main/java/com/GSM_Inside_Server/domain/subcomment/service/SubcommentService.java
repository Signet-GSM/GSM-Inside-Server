package com.GSM_Inside_Server.domain.subcomment.service;

import com.GSM_Inside_Server.domain.comment.repository.CommentRepository;
import com.GSM_Inside_Server.domain.subcomment.dto.req.SubcommentReqDTO;
import com.GSM_Inside_Server.domain.subcomment.dto.res.SubcommentResDTO;
import com.GSM_Inside_Server.domain.subcomment.entity.SubcommentEntity;
import com.GSM_Inside_Server.domain.subcomment.repository.SubcommentRepository;
import com.GSM_Inside_Server.global.error.CustomException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.GSM_Inside_Server.global.error.CustomErrorCode.*;

@Service
public class SubcommentService {

    private final SubcommentRepository subcommentRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public SubcommentService(SubcommentRepository subcommentRepository, CommentRepository commentRepository) {
        this.subcommentRepository = subcommentRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public SubcommentResDTO uploadSubcommnet(SubcommentReqDTO dto){
        SubcommentEntity subcomment = subcommentRepository.save(SubcommentEntity.builder()
                .comment(
                        commentRepository.findById(dto.getComment())
                                .orElseThrow(() -> new CustomException(COMMENT_NOT_FOUND))
                )
                .content(dto.getContent())
                .name(dto.getName())
                .password(dto.getPassword())
                .build()
        );

        return SubcommentResDTO.builder()
                .id(subcomment.getId())
                .comment(subcomment.getComment().getId())
                .content(subcomment.getContent())
                .name(subcomment.getName())
                .build();
    }

    @Transactional
    public void putSubcomment(Long id, SubcommentReqDTO dto) {
        SubcommentEntity subcomment = subcommentRepository.findById(id)
                .orElseThrow(() -> new CustomException(SUBCOMMNET_NOT_FOUND));

        if (!subcomment.getPassword().equals(dto.getPassword())) throw new CustomException(INVALID_PASSWORD);

        subcomment.update(dto.getContent());
    }

    @Transactional
    public void deleteSubcomment(Long id) {
        subcommentRepository.deleteById(id);
    }
}
