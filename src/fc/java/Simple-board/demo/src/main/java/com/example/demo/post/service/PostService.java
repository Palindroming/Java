package com.example.demo.post.service;


import com.example.demo.post.PostEntity;
import com.example.demo.post.PostRepository;
import com.example.demo.post.model.PostRequest;
import com.example.demo.post.model.PostViewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostEntity create(
            PostRequest postRequest
    ) {
        var entity = PostEntity.builder()
                .boardId(1L)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .status("REGISTERED")
                .email(postRequest.getEmail())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);

    }


    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findById(postViewRequest.getPostId())
                .map(it -> {
                    if (!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "password does not match %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));


                    }
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("Post not found" + postViewRequest.getPostId());
                        });
    }

    public List<PostEntity> all() {

        return postRepository.findByStatusNot("DELETED");


    }

    public void delete(PostViewRequest postViewRequest) {

        postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")
                .map(it -> {
                    if (!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "password does not match %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));


                    }
                    it.setStatus("DELETED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("Post not found" + postViewRequest.getPostId());
                        });

    }






}
