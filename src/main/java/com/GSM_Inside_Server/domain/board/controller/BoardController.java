package com.GSM_Inside_Server.domain.board.controller;

import com.GSM_Inside_Server.domain.board.dto.req.BoardReqDTO;
import com.GSM_Inside_Server.domain.board.dto.res.BoardResDTO;
import com.GSM_Inside_Server.domain.board.dto.res.getAllBoardListDTO;
import com.GSM_Inside_Server.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public ResponseEntity<List<getAllBoardListDTO>> getAllBoardList(
            @RequestParam(required = false, defaultValue = "default") String order) {
        return new ResponseEntity<>(boardService.getAllBoardList(order), HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<BoardResDTO> getBoardById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.getBoardById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BoardResDTO> uploadBoard(@RequestBody BoardReqDTO uploadBoardReqDTO){
        return new ResponseEntity<>(boardService.uploadBoard(uploadBoardReqDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<Void> putBoard(@RequestBody BoardReqDTO uploadBoardReqDTO, @PathVariable Long id){
        boardService.putBoard(id, uploadBoardReqDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
