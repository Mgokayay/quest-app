package com.project.questapp.service;

import com.project.questapp.dto.LikeResponseDto;
import com.project.questapp.entity.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {

    List<Like> findAllCommentsWithParam(Optional<Long>postId, Optional<Long> userId);

    Like save(LikeResponseDto like);
    Like delete(Long id);

    Like findById(Long id);
}
