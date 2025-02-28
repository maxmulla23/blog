package com.blog.api.service;

import com.blog.api.models.Blog;
import com.blog.api.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog addBlog(Blog blog, MultipartFile imageFile) throws IOException {
        blog.setImageName(imageFile.getOriginalFilename());
        blog.setType(imageFile.getContentType());
        blog.setImage(imageFile.getBytes());

        return blogRepository.save(blog);
    }
}
