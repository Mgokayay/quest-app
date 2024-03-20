package com.project.questapp.service;


import com.project.questapp.dto.LikeResponseDto;
import com.project.questapp.entity.Like;
import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;
import com.project.questapp.repository.LikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;
    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository,
                           PostService postService,
                           UserService userService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Like> findAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (postId.isPresent() && userId.isPresent()){
            return likeRepository.findByPostIdAndUserId(userId.get(),postId.get());
        } else if (userId.isPresent()){
            return likeRepository.findByPostId(userId.get());
        } else if (postId.isPresent()){
            return likeRepository.findByPostId(postId.get());
        }
        return likeRepository.findAll();
    }

    @Override
    public Like save(LikeResponseDto likeRes) {
        User user = userService.findById(likeRes.getUserId());
        Post post = postService.findById(likeRes.getPostId());
        if (user != null && post != null){
            Like newLike = new Like();
            newLike.setUser(user);
            newLike.setPost(post);
            return likeRepository.save(newLike);
        }
        return null;
    }

    @Override
    public Like delete(Long id) {
        Like like = findById(id);
        likeRepository.delete(like);
        return like;
    }

    @Override
    public Like findById(Long id) {
        return likeRepository.findById(id).orElse(null);
    }


}