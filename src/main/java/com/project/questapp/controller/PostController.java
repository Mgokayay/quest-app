package com.project.questapp.controller;

import com.project.questapp.dto.PostResponseDto;
import com.project.questapp.dto.PostUpdateReq;
import com.project.questapp.entity.Post;
import com.project.questapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/posts")
public class PostController {

    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public Post save(@RequestBody PostResponseDto responseDto){
        return postService.save(responseDto);
    }

    @GetMapping("/")
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.findAll(userId);
    }

    @GetMapping("/{postId}")
    public Post findById(@PathVariable Long postId){
        return postService.findById(postId);
    }

    @DeleteMapping("/{postId}")
    public Post delete(@PathVariable Long postId){
        return postService.delete(postId);
    }

    @PutMapping("/{postId}")
    public Post update(@RequestBody PostUpdateReq updateReq,@PathVariable Long postId){
        return  postService.update(updateReq,postId);
    }
}
