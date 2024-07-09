package com.GSM_Inside_Server.domain.comment.controller;

import com.GSM_Inside_Server.domain.comment.dto.req.CommentReqDTO;
import com.GSM_Inside_Server.domain.comment.dto.res.CommentResDTO;
import com.GSM_Inside_Server.domain.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<CommentResDTO> uploadComment(@RequestBody CommentReqDTO commentReqDTO) {
        return new ResponseEntity<>(commentService.uploadComment(commentReqDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<Void> updateComment(@PathVariable Long id,
            @RequestBody CommentReqDTO commentReqDTO) {
        commentService.putComment(id, commentReqDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
