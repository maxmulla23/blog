package com.blog.api.controllers;

import com.blog.api.dto.UserInfoDto;
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
    @Autowired
    private UserService userService;

    @PostMapping("/userinfo/{username}")
    public ResponseEntity<UserInfo> createInfo(@PathVariable String username, @RequestBody UserInfo userInfo) {
        return ResponseEntity.ok(userInfoService.createInfo(userInfo, username));
    }

    @GetMapping("/userinfo/get/{username}")
    public ResponseEntity<UserInfoDto> getInfoByUser(@PathVariable String username) {
        UserEntity user = userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        // Call the service method with the correct user entity
        UserInfoDto userInfoDto = userInfoService.getInfoByUser(user);

        return ResponseEntity.ok(userInfoDto);
    }
}
