package com.blog.api.service;

import com.blog.api.models.UserEntity;
import com.blog.api.models.UserInfo;
import com.blog.api.repository.UserInfoRepository;
import com.blog.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRepository userRepository;

    public UserInfo createInfo(UserInfo userInfo, String username) {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("user not found"));
        userInfo.setUser(user);

        return userInfoRepository.save(userInfo);
    }
}
