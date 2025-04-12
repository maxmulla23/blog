package com.blog.api.service;

import com.blog.api.dto.UserInfoDto;
import com.blog.api.models.UserEntity;
import com.blog.api.models.UserInfo;
import com.blog.api.repository.UserInfoRepository;
import com.blog.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


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

    public UserInfoDto getInfoByUser(UserEntity user) {
        Optional<UserInfo> userInfo1 = userInfoRepository.findByUser(user);
        return userInfo1.map(this::mapToDto).orElseThrow(() -> new RuntimeException("not found" +user.getUsername()));
    }

    private UserInfoDto mapToDto(UserInfo userInfo) {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setFirstName(userInfo.getFirstName());
        userInfoDto.setLastName(userInfo.getLastName());
        userInfoDto.setEmail(userInfo.getEmail());
        userInfoDto.setBio(userInfo.getBio());
        return userInfoDto;
    }
    private UserInfo mapToEntity(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoDto.getId());
        userInfo.setFirstName(userInfoDto.getFirstName());
        userInfo.setLastName(userInfoDto.getLastName());
        userInfo.setEmail(userInfoDto.getEmail());
        userInfo.setBio(userInfoDto.getBio());
        return userInfo;
    }
}
