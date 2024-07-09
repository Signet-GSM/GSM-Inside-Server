package com.GSM_Inside_Server.domain.subcomment.controller;

import com.GSM_Inside_Server.domain.subcomment.dto.req.SubcommentReqDTO;
import com.GSM_Inside_Server.domain.subcomment.dto.res.SubcommentResDTO;
import com.GSM_Inside_Server.domain.subcomment.service.SubcommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub")
public class SubcommentController {

    private final SubcommentService subcommentService;

    public SubcommentController(SubcommentService subcommentService) {
        this.subcommentService = subcommentService;
    }

    @PostMapping("/")
    public ResponseEntity<SubcommentResDTO> createSubcomment(@RequestBody SubcommentReqDTO dto){
        return new ResponseEntity<>(subcommentService.uploadSubcommnet(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<Void> putSubcomment(@PathVariable Long id, @RequestBody SubcommentReqDTO dto){
        subcommentService.putSubcomment(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<Void> deleteSubcomment(@PathVariable Long id){
        subcommentService.deleteSubcomment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
