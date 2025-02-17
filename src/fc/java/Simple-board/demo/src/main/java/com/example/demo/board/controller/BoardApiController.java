package com.example.demo.board.controller;


import com.example.demo.board.db.BoardEntity;
import com.example.demo.board.db.BoardRepository;
import com.example.demo.board.model.BoardRequest;
import com.example.demo.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {


    private final BoardService boardService;



    @PostMapping("")
    public BoardEntity create(
        @Valid
        @RequestBody
        BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }
}
