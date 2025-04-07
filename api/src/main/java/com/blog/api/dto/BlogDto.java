package com.blog.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogDto {
    private int id;
    private String title;
    private String body;
    private List<String> genres;
    private LocalDateTime updatedAt;

    public BlogDto() {
    }

    public BlogDto(int id, String title, String body, String createdBy, LocalDateTime createdAt, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.updatedAt = updatedAt;
    }
}
