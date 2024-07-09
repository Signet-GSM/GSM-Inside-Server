package com.GSM_Inside_Server.domain.board.service;

import com.GSM_Inside_Server.domain.board.dto.req.BoardReqDTO;
import com.GSM_Inside_Server.domain.board.dto.res.BoardResDTO;
import com.GSM_Inside_Server.domain.board.dto.res.getAllBoardListDTO;
import com.GSM_Inside_Server.domain.comment.dto.res.CommentResDTO;
import com.GSM_Inside_Server.domain.image.dto.res.ImageUrlResDTO;
import com.GSM_Inside_Server.domain.board.entity.BoardEntity;
import com.GSM_Inside_Server.domain.image.entity.ImageEntity;
import com.GSM_Inside_Server.domain.board.repository.BoardRepository;
import com.GSM_Inside_Server.domain.image.repository.ImageRepository;
import com.GSM_Inside_Server.domain.gallery.repository.GalleryRepository;
import com.GSM_Inside_Server.domain.subcomment.dto.res.SubcommentResDTO;
import com.GSM_Inside_Server.global.error.CustomException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.GSM_Inside_Server.global.error.CustomErrorCode.*;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;
    private final GalleryRepository galleryRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, ImageRepository imageRepository, GalleryRepository galleryRepository) {
        this.boardRepository = boardRepository;
        this.imageRepository = imageRepository;
        this.galleryRepository = galleryRepository;
    }

    @Transactional
    public List<getAllBoardListDTO> getAllBoardList(String order){
        List<BoardEntity> board = switch (order) {
            case "view" -> boardRepository.findAllByOrderByView();
            case "like" -> boardRepository.findAllByOrderByLike();
            default -> boardRepository.findAllByOrderByDate();
        };

        return board.stream()
                .map(b -> getAllBoardListDTO.builder()
                        .id(b.getId())
                        .gallery(b.getGallery().getId())
                        .title(b.getTitle())
                        .content(b.getContent())
                        .name(b.getName())
                        .isAdmin(b.getIsAdmin())
                        .like(b.getLike())
                        .image(b.getImages().get(0).getUrl())
                        .build()
                ).toList();

    }

    @Transactional
    public BoardResDTO getBoardById(Long id){
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(BOARD_NOT_FOUND));

        return BoardResDTO.builder()
                .id(board.getId())
                .gallery(board.getGallery().getId())
                .title(board.getTitle())
                .content(board.getContent())
                .name(board.getName())
                .isAdmin(board.getIsAdmin())
                .like(board.getLike())
                .dislike(board.getDislike())
                .view(board.getView())
                .images(board.getImages().stream()
                        .map(i -> new ImageUrlResDTO(i.getUrl())).toList()
                )
                .comments(board.getComments().stream()
                        .map(c -> CommentResDTO.builder()
                                .id(c.getId())
                                .board(c.getBoard().getId())
                                .subcomments(c.getSubcomment().stream()
                                        .map(sc -> SubcommentResDTO.builder()
                                                .id(sc.getId())
                                                .comment(sc.getComment().getId())
                                                .content(sc.getContent())
                                                .name(sc.getName())
                                                .build()
                                        ).toList()
                                )
                                .content(c.getContent())
                                .name(c.getName())
                                .build()
                        ).toList()
                ).build();
    }

    @Transactional
    public BoardResDTO uploadBoard(BoardReqDTO dto){
        BoardEntity board = boardRepository.save(BoardEntity.builder()
                .gallery(galleryRepository.findById(dto.getGallery())
                        .orElseThrow(() -> new CustomException(GALLERY_NOT_FOUND)))
                .title(dto.getTitle())
                .content(dto.getContent())
                .name(dto.getName())
                .password(dto.getPassword())
                .date(LocalDateTime.now())
                .view(0L)
                .like(0)
                .dislike(0)
                .build()
        );

        List<ImageEntity> image = dto.getImages().stream()
                .map(i -> imageRepository.save(ImageEntity.builder()
                        .board(board)
                        .url(i.getUrl())
                        .build()
                )).toList();

        return BoardResDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .view(board.getView())
                .like(board.getLike())
                .dislike(board.getDislike())
                .gallery(board.getGallery().getId())
                .isAdmin(board.getIsAdmin())
                .images(image.stream()
                        .map(i -> ImageUrlResDTO.builder()
                                .url(i.getUrl())
                                .build())
                        .toList())
                .build();
    }

    @Transactional
    public void putBoard(Long id, BoardReqDTO dto){
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(BOARD_NOT_FOUND));

        if (!board.getPassword().equals(dto.getPassword())){
            throw new CustomException(INVALID_PASSWORD);
        }

        board.update(
                dto.getTitle(),
                dto.getContent()
        );
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }

}
