package com.blog.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogDto {
    private int id;
    private String title;
    private String body;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;

    public BlogDto() {
    }

    public BlogDto(int id, String title, String body, String createdBy, LocalDateTime createdAt, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.lastModifiedDate = lastModifiedDate;
    }
}
