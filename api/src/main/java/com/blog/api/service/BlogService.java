package com.blog.api.service;

import com.blog.api.dto.BlogDto;

import java.util.List;

public interface BlogService {
    BlogDto createBlog(BlogDto blogDto);
    List<BlogDto> getAllBlogs();
    BlogDto getBlogById(int blogId);
    BlogDto updateBlog(int blogId, BlogDto blogDto);
    void DeleteBlog(int blogId);
}
