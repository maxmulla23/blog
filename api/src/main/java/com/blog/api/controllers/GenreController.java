package com.blog.api.controllers;

import com.blog.api.dto.GenreDto;
import com.blog.api.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class GenreController {
    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/genre/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto) {
        return new ResponseEntity<>(genreService.creategenre(genreDto), HttpStatus.CREATED);
    }
}
