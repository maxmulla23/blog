package com.blog.api.repository;

import com.blog.api.models.Blog;
import com.blog.api.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByUserOrderByCreatedDateDesc(UserEntity user, Pageable pageable);
    Page<Blog> findAllByOrderByCreatedDateDesc(Pageable pageable);

    Optional<Blog> findById(int id);

    void deletebyid(int id);
}
