package com.blog.api.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Data
public class CreateBlogRequest {
    private String title;
    private String body;
    private MultipartFile image;
    private List<String> genres;
}
