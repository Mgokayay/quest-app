package com.project.questapp.controller;

import com.project.questapp.dto.LikeResponseDto;
import com.project.questapp.entity.Like;
import com.project.questapp.service.LikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {


    private LikeService likeService;
    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @PostMapping("/")
    public Like save(@RequestBody LikeResponseDto likeResponseDto){
        return likeService.save(likeResponseDto);
    }
    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId
                                 ,@RequestParam Optional<Long> postId ){
        return likeService.findAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{userId}")
    public Like findById(@PathVariable Long likeId){
        return likeService.findById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public Like delete(@PathVariable Long likeId){
        return likeService.delete(likeId);
    }
}
