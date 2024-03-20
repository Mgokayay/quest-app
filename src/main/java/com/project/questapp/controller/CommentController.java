package com.project.questapp.controller;


import com.project.questapp.dto.CommentResponseDto;
import com.project.questapp.dto.CommentUpdateReq;
import com.project.questapp.entity.Comment;
import com.project.questapp.service.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/comments")
@NoArgsConstructor
public class CommentController {


    private CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public Comment save(@RequestBody CommentResponseDto commentResponseDto){
        return commentService.save(commentResponseDto);
    }

    @GetMapping
    public List<Comment> findAllComments(@RequestParam Optional<Long> userId
                                         ,@RequestParam Optional<Long> postId){
        return commentService.findAllCommentWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment findById(@PathVariable Long commentId){
        return commentService.findById(commentId);
    }

    @DeleteMapping("/{commentId}")
    public Comment delete(@PathVariable Long commentId){
        return commentService.delete(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment update(@RequestBody CommentUpdateReq updateReq,@PathVariable Long commentId){
        return commentService.update(updateReq,commentId);
    }
}
