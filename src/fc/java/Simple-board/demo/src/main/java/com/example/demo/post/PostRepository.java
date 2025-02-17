package com.example.demo.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {

         Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);

         List<PostEntity> findByStatusNot(String status);
}
