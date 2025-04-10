package com.blog.api.service;

import com.blog.api.dto.BlogDto;
import com.blog.api.dto.CreateBlogRequest;
import com.blog.api.models.Blog;
import com.blog.api.models.Genre;
import com.blog.api.models.UserEntity;
import com.blog.api.repository.BlogRepository;
import com.blog.api.repository.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @Value("${static.images}")
    private String uploadPath;

    private UserDetailsService userDetailsService;

    public Blog createBlog(CreateBlogRequest createBlogRequest, UserEntity author, List<String> genreNames) throws IOException {
        Blog blog = new Blog();
        blog.setTitle(createBlogRequest.getTitle());
        blog.setBody(createBlogRequest.getBody());
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

        if (createBlogRequest.getImage() != null && !createBlogRequest.getImage().isEmpty()) {
            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            String filename = UUID.randomUUID().toString() + "_" + createBlogRequest.getImage().getOriginalFilename();
            Path filePath = Paths.get(uploadPath, filename);
            Files.copy(createBlogRequest.getImage().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            blog.setImage("/uploads/" + filename); // Save the image path
        }

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

    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Page<Blog> getBlogsByUser(UserEntity user, Pageable pageable) {
        return blogRepository.findByUser(user, pageable);
    }

    public Page<Blog> getBlogsByGenre(String genreName, Pageable pageable) {
        return blogRepository.findByGenres_Name(genreName, pageable);
    }

    @Transactional
    public void deleteBlog(int blogId) {
        blogRepository.deleteById(blogId);
    }
}
