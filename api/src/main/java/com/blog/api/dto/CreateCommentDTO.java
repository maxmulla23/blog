package com.blog.api.dto;

import lombok.Data;

@Data
public class CreateCommentDTO {
    private int blogId;
    private String content;

    public CreateCommentDTO(int blogId, String content) {
        this.blogId = blogId;
        this.content = content;
    }
}
