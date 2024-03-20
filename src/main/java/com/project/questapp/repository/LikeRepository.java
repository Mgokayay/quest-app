package com.project.questapp.repository;

import com.project.questapp.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByPostIdAndUserId(Long userId, Long postId);
    List<Like> findByPostId(Long postId);
    List<Like> findByUserId(Long userId);
}
