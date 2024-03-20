package com.project.questapp.service;

import com.project.questapp.dto.PostResponseDto;
import com.project.questapp.dto.PostUpdateReq;
import com.project.questapp.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post>  findAll(Optional<Long> userId);
    Post save(PostResponseDto post);
    Post delete(Long id);

    Post findById(Long id);

    Post update(PostUpdateReq postUpdateReq, Long id);
}
