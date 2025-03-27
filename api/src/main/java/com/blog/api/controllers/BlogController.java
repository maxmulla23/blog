package com.blog.api.controllers;

import com.blog.api.dto.BlogDto;
import com.blog.api.models.Blog;
import com.blog.api.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("blog")
    public ResponseEntity<Blog> createBlog(@RequestPart BlogDto blogDto, Principal principal) {
            Blog blog1 = blogService.createBlog(blogDto, principal);
            return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest, Principal principal){
//        Address address = addressService.createAddress(addressRequest,principal);
//        return new ResponseEntity<>(address, HttpStatus.OK);
//    }
}
