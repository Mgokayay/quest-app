package com.project.questapp.service;

import com.project.questapp.dto.CommentResponseDto;
import com.project.questapp.dto.CommentUpdateReq;
import com.project.questapp.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment>  findAllCommentWithParam(Optional<Long> userId,Optional<Long> postId);
    Comment save(CommentResponseDto comment);
    Comment delete(Long id);
    Comment findById(Long id);
    Comment update(CommentUpdateReq commentUpdateReq, Long id);
}
