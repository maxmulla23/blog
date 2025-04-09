package com.blog.api.repository;

import com.blog.api.models.UserEntity;
import com.blog.api.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByUser(UserEntity user);
}
