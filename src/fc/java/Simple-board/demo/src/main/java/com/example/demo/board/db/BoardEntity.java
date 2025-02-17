package com.example.demo.board.db;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="board_name")
    private String boardName;

    private String status;




}
