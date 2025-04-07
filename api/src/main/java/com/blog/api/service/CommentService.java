package com.blog.api.service;

import com.blog.api.dto.CommentDTO;
import com.blog.api.dto.CreateCommentDTO;
import com.blog.api.models.Comment;
import com.blog.api.models.UserEntity;

import java.util.List;

public interface CommentService {
    Comment createComment(int blogId, UserEntity user, Comment comment);
    List<CommentDTO> getCommentByBlogId(int id);
    CommentDTO getCommentById(int commentId, int blogId);
    CreateCommentDTO updateComment(int commentId, int blogId, CreateCommentDTO commentDTO);
    void deleteComment(int blogId, int commentId);
}
