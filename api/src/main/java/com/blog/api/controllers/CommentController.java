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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private UserService userService;
    private CommentService commentService;
    private BlogService blogService;

    @Autowired
    public CommentController(UserService userService, CommentService commentService, BlogService blogService) {
        this.userService = userService;
        this.commentService = commentService;
        this.blogService = blogService;
    }

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

    @GetMapping("/comment/blog/{blogId}")
    public ResponseEntity<List<Comment>> getCommentsByBlogId(@PathVariable int blogId) {
        List<Comment> comments = commentService.getCommentByBlogId(blogId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
