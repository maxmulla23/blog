package com.blog.api.service;

import com.blog.api.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto creategenre(GenreDto genreDto);
    List<GenreDto> getAllGenres();
    GenreDto getGenreById(int genreId);
    GenreDto updateGenre(int genreId, GenreDto genreDto);
    void DeleteGenre(int GenreId);
}
