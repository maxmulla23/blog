package com.blog.api.controllers;

import com.blog.api.dto.CreateCommentDTO;
import com.blog.api.models.Comment;
import com.blog.api.models.UserEntity;
import com.blog.api.service.BlogService;
import com.blog.api.service.CommentService;
import com.blog.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody CreateCommentDTO createCommentDTO, Principal principal) {
        String username = principal.getName();
        Optional<UserEntity> user = userService.getUserByUsername(username);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Comment comment = new Comment();
        comment.setContent(createCommentDTO.getContent());

        Comment newComment = commentService.createComment(createCommentDTO.getBlogId(), user.get(), comment);

        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
}
