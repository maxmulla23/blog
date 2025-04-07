package com.blog.api.dto;

import com.blog.api.models.Blog;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class CommentDTO {
    private int id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;
}
