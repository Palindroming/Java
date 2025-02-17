package com.example.demo.post;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name= "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long boardId;

    @Column(name = "username")
    private String userName;

    private String password;

    private String title;

    private String email;

    private String content;

    private String status;

    private LocalDateTime postedAt;







}
