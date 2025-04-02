package com.blog.api.dto;


import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class CreateBlogRequest {
    private String title;
    private String body;

    private List<String> genres; // This will hold the genre names

    // Getters and setters
}
