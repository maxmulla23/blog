package com.blog.api.controllers;

import com.blog.api.dto.BlogDto;

import com.blog.api.dto.CreateBlogRequest;
import com.blog.api.models.Blog;
import com.blog.api.models.UserEntity;
import com.blog.api.service.BlogService;
import com.blog.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;


@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "blog/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Blog> createNewBlog(@ModelAttribute CreateBlogRequest createBlogRequest, Principal principal) {
        String username = principal.getName(); // Get logged-in user's username
        Optional<UserEntity> author = userService.getUserByUsername(username);
        if (author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        try {
            Blog newBlog = blogService.createBlog(createBlogRequest, author.get(), createBlogRequest.getGenres());
            return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException("Could not save image", e);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Blog> updateExistingBlog( @PathVariable int id, @RequestBody BlogDto updateBlogRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Optional<UserEntity> currentUserOptional = userService.getUserByUsername(currentUsername);
        if (currentUserOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        UserEntity currentUser = currentUserOptional.get();

        Optional<Blog> existingBlogOptional = blogService.getBlogById(id);
        if (existingBlogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Blog existingBlog = existingBlogOptional.get();

        // Check if the current user is the author of the blog (basic authorization)
        if (!existingBlog.getUser().getUsername().equals(currentUsername)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Blog updatedBlog = new Blog();
        updatedBlog.setTitle(updateBlogRequest.getTitle());
        updatedBlog.setBody(updateBlogRequest.getBody());

        Blog result = blogService.updateBlog(id, updatedBlog, updateBlogRequest.getGenres());

        if (result == null) {
            return ResponseEntity.notFound().build(); // Should ideally not happen if we found it initially
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("blogs")
    public ResponseEntity<Page<Blog>> getBlogs(@PageableDefault(size = 10, sort = "createdAt" , direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.getAllBlogs(pageable);

        return ResponseEntity.ok(blogs);
    }

    @GetMapping("blogs/user/{username}")
    public ResponseEntity<Page<Blog>> getBlogsByUser(@PathVariable String username, @PageableDefault(size = 10, sort = "createdAt" , direction = Sort.Direction.DESC) Pageable pageable) {
        Optional<UserEntity> user = userService.getUserByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Page<Blog> blogs = blogService.getBlogsByUser(user.get(), pageable);
        return ResponseEntity.ok(blogs);
    }

}
