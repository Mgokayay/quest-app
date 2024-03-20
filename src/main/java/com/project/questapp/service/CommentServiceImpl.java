package com.project.questapp.service;

import com.project.questapp.dto.CommentResponseDto;
import com.project.questapp.dto.CommentUpdateReq;
import com.project.questapp.entity.Comment;
import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;
import com.project.questapp.repository.CommentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@NoArgsConstructor
public class CommentServiceImpl implements CommentService{
    private  CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository
                               ,UserService userService
                               ,PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }



    @Override
    public List<Comment> findAllCommentWithParam(Optional<Long> userId,Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return commentRepository.findByPostIdAndUserId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }
        return commentRepository.findAll();
    }



    @Override
    public Comment save(CommentResponseDto comment) {
        User user = userService.findById(comment.getUserId());
        Post post = postService.findById(comment.getPostId());
        if (user != null && post != null){
            Comment saveComment = new Comment();
            saveComment.setText(comment.getText());
            saveComment.setUser(user);
            saveComment.setPost(post);
            return commentRepository.save(saveComment);
        }
        return null;
    }

    @Override
    public Comment delete(Long id) {
        Comment comment = findById(id);
        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment update(CommentUpdateReq commentUpdateReq, Long id) {
        Comment existComment = findById(id);
        existComment.setText(commentUpdateReq.getText());
        return commentRepository.save(existComment);
    }
}
