package com.blog.api.controllers;

import com.blog.api.dto.GenreDto;
import com.blog.api.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class GenreController {
    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("genre/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto) {
        return new ResponseEntity<>(genreService.creategenre(genreDto), HttpStatus.CREATED);
    }

    @GetMapping("genre")
    public ResponseEntity<List<GenreDto>> getGenre() {
        return new ResponseEntity<>(genreService.getAllGenres(), HttpStatus.OK);
    }
    @GetMapping("genre/{id}")
    public ResponseEntity<GenreDto> genre(@PathVariable int genreId) {
        GenreDto genreDto = genreService.getGenreById(genreId);
        return new ResponseEntity<>(genreDto, HttpStatus.OK);
    }

    @PutMapping("genre/{id}")
    public ResponseEntity<GenreDto> updateGenre(@PathVariable int genreId, @RequestBody GenreDto genreDto) {
        GenreDto updatedGenre = genreService.updateGenre(genreId, genreDto);

        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }
    @DeleteMapping("genre/{id}")
    public ResponseEntity<String> delete(@PathVariable int genreId) {
        genreService.DeleteGenre(genreId);
        return new ResponseEntity<>("Genre deleted successfully", HttpStatus.OK);
    }
}
