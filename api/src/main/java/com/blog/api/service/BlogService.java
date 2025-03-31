package com.blog.api.service;

import com.blog.api.dto.BlogDto;
import com.blog.api.models.Blog;
import com.blog.api.models.UserEntity;
import com.blog.api.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    private UserDetailsService userDetailsService;

    public Blog createBlog(BlogDto blogDto, Principal principal) {
        UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(principal.getName());

        Blog blog = Blog.builder()
                .title(blogDto.getTitle())
                .body(blogDto.getBody())
                .createdDate(blogDto.getCreatedDate())
                .user(user)
                .build();
        return blogRepository.save(blog);
    }
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }
}
