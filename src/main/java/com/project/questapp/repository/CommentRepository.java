package com.project.questapp.repository;

import com.project.questapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>{
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByPostIdAndUserId(Long userId,Long postId);
}
