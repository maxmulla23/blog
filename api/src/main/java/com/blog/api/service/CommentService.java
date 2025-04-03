package com.blog.api.service;

import com.blog.api.dto.CreateCommentDTO;
import com.blog.api.models.UserEntity;

import java.util.List;

public interface CommentService {
    CreateCommentDTO createComment(int blogId, UserEntity user, CreateCommentDTO commentDTO);
    List<CreateCommentDTO> getCommentByBlogId(int id);
     CreateCommentDTO getCommentById(int commentId, int blogId);
    CreateCommentDTO updateComment(int commentId, int blogId, CreateCommentDTO commentDTO);
    void deleteComment(int blogId, int commentId);
}
