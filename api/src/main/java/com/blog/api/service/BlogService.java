package com.blog.api.service;

import com.blog.api.dto.BlogDto;
import com.blog.api.models.Blog;
import com.blog.api.models.UserEntity;
import com.blog.api.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    private UserDetailsService userDetailsService;

    public Blog createBlog(BlogDto blogDto, Principal principal) {
        UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(principal.getName());

        Blog blog = Blog.builder()
                .title(blogDto.getTitle())
                .body(blogDto.getBody())
                .user(user)
                .build();
        return blogRepository.save(blog);
    }
}
