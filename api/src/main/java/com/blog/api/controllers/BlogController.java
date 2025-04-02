package com.blog.api.controllers;

import com.blog.api.dto.BlogDto;

import com.blog.api.dto.CreateBlogRequest;
import com.blog.api.models.Blog;
import com.blog.api.models.UserEntity;
import com.blog.api.service.BlogService;
import com.blog.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("blog/create")
    public ResponseEntity<Blog> createNewBlog(@RequestBody CreateBlogRequest createBlogRequest, Principal principal) {
        String username = principal.getName(); // Get logged-in user's username
        Optional<UserEntity> author = userService.getUserByUsername(username);
        if (author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Blog blog = new Blog();
        blog.setTitle(createBlogRequest.getTitle());
        blog.setBody(createBlogRequest.getBody());
        Blog createdBlog = blogService.createBlog(blog, author.get(), createBlogRequest.getGenres());
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest, Principal principal){
//        Address address = addressService.createAddress(addressRequest,principal);
//        return new ResponseEntity<>(address, HttpStatus.OK);
//    }
}
