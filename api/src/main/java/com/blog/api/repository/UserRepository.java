package com.blog.api.repository;

import com.blog.api.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> FindByUsername(String username);
    Boolean existByUsername(String username);
}
