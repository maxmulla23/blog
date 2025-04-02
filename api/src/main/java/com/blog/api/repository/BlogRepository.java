package com.blog.api.repository;

import com.blog.api.models.Blog;
import com.blog.api.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByUser(UserEntity user);
    Page<Blog> findByGenres_Name(String genreName, Pageable pageable);
    Optional<Blog> findById(int id);


}
