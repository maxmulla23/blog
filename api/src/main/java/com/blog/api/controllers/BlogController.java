package com.blog.api.controllers;

import com.blog.api.models.Blog;
import com.blog.api.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class BlogController {

//    @Autowired
//    private BlogService blogService;
//
//    @PostMapping("blog")
//    public ResponseEntity<?> addBlog(@RequestPart Blog blog, @RequestPart MultipartFile imageFile)
//    {
//        try{
//            Blog blog1 = blogService.addBlog(blog, imageFile);
//            return new ResponseEntity<>(blog1, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
