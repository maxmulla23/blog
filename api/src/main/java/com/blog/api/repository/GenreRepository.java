package com.blog.api.repository;

import com.blog.api.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByBlogId(int blogId);
}
