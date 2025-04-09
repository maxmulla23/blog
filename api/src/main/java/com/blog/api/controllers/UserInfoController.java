package com.blog.api.controllers;

import com.blog.api.models.UserEntity;
import com.blog.api.models.UserInfo;
import com.blog.api.service.UserInfoService;
import com.blog.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    private UserService userService;

    @PostMapping("/userinfo/{username}")
    public ResponseEntity<UserInfo> createInfo(@PathVariable String username, @RequestBody UserInfo userInfo, Principal principal) {
//        username = principal.getName(); // Get logged-in user's username
//        Optional<UserEntity> user = userService.getUserByUsername(username);
        return ResponseEntity.ok(userInfoService.createInfo(userInfo, username));
    }
}
