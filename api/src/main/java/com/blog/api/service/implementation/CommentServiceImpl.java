package com.blog.api.service.implementation;

import com.blog.api.dto.CommentDTO;
import com.blog.api.dto.CreateCommentDTO;
import com.blog.api.exceptions.BlogNotFoundException;
import com.blog.api.models.Blog;
import com.blog.api.models.Comment;
import com.blog.api.models.UserEntity;
import com.blog.api.repository.BlogRepository;
import com.blog.api.repository.CommentRepository;
import com.blog.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private UserDetailsService userDetailsService;
    private BlogRepository blogRepository;

    @Autowired
    public CommentServiceImpl(UserDetailsService userDetailsService, BlogRepository blogRepository, CommentRepository commentRepository) {
        this.userDetailsService = userDetailsService;
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(int blogId, UserEntity user, Comment comment) {

        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new BlogNotFoundException("blog not found"));

        comment.setUser(user);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setBlog(blog);

        return commentRepository.save(comment);
    }

    @Override
    public List<CommentDTO> getCommentByBlogId(int id) {
        return List.of();
    }

    @Override
    public CommentDTO getCommentById(int commentId, int blogId) {
        return null;
    }

    @Override
    public CreateCommentDTO updateComment(int commentId, int blogId, CreateCommentDTO commentDTO) {
        return null;
    }

    @Override
    public void deleteComment(int blogId, int commentId) {

    }

//    private CreateCommentDTO mapToDto(Comment comment) {
//        CreateCommentDTO commentDTO = new CreateCommentDTO();
//        commentDTO.setContent(comment.getContent());
//
//        return commentDTO;
//    }
//
//    private Review mapToEntity(ReviewDto reviewDto) {
//        Review review = new Review();
//        review.setId(reviewDto.getId());
//        review.setTitle(reviewDto.getTitle());
//        review.setContent(reviewDto.getContent());
//        review.setStars(reviewDto.getStars());
//        return review;
//    }
}
