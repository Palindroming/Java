package com.example.demo.board.service;


import com.example.demo.board.db.BoardEntity;
import com.example.demo.board.db.BoardRepository;
import com.example.demo.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;

    public BoardEntity create(BoardRequest boardRequest) {
        var entity =  BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        return boardRepository.save(entity);
    }
}
