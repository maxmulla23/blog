package com.blog.api.dto;

import lombok.Data;

@Data
public class CreateCommentDTO {
    private String content;

    public CreateCommentDTO(String content) {
        this.content = content;
    }
}
