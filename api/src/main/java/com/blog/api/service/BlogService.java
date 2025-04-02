package com.blog.api.service;

import com.blog.api.dto.BlogDto;
import com.blog.api.models.Blog;
import com.blog.api.models.Genre;
import com.blog.api.models.UserEntity;
import com.blog.api.repository.BlogRepository;
import com.blog.api.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private GenreRepository genreRepository;

    private UserDetailsService userDetailsService;

    public Blog createBlog(Blog blog, UserEntity author, List<String> genreNames) {
        blog.setUser(author);
        blog.setCreatedAt(LocalDateTime.now());

        List<Genre> genres = new ArrayList<>();
        for (String genreName : genreNames) {
            Optional<Genre> existingGenre = genreRepository.findByName(genreName);
            Genre genre = existingGenre.orElseGet(() -> {
                Genre newGenre = new Genre();
                newGenre.setName(genreName);
                return genreRepository.save(newGenre);
            });
            genres.add(genre);
        }
        blog.setGenres((List<Genre>) genres);

        return blogRepository.save(blog);
    }

    public Blog updateBlog(int blogId, Blog updatedBlog, List<String> genreNames) {
        Optional<Blog> existingBlogOptional = blogRepository.findById(blogId);
        if (existingBlogOptional.isEmpty()) {
            return null; // Or throw an exception
        }
        Blog existingBlog = existingBlogOptional.get();

        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setBody(updatedBlog.getBody());
        existingBlog.setUpdatedAt(LocalDateTime.now());

        List<Genre> genres = new ArrayList<>();
        for (String genreName : genreNames) {
            Optional<Genre> existingGenre = genreRepository.findByName(genreName);
            Genre genre = existingGenre.orElseGet(() -> {
                Genre newGenre = new Genre();
                newGenre.setName(genreName);
                return genreRepository.save(newGenre);
            });
            genres.add(genre);
        }
        existingBlog.setGenres(genres);

        return blogRepository.save(existingBlog);
    }

    public Optional<Blog> getBlogById(int blogId) {
        return blogRepository.findById(blogId);
    }


    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }
}
