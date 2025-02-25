package com.blog.api.service.implementation;

import com.blog.api.dto.GenreDto;
import com.blog.api.exceptions.GenreNotFoundException;
import com.blog.api.models.Genre;
import com.blog.api.repository.GenreRepository;
import com.blog.api.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public GenreDto creategenre(GenreDto genreDto) {
        Genre genre = mapToEntity(genreDto);

        Genre newGenre = genreRepository.save(genre);

        return mapToDto(newGenre);
    }

    @Override
    public List<GenreDto> getAllGenres() {
        List<Genre> genre = genreRepository.findAll();
        return genre.stream().map(g -> mapToDto(g)).collect(Collectors.toList());
    }

    @Override
    public GenreDto getGenreById(int genreId) {
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException("Genre not found"));

        return mapToDto(genre);
    }

    @Override
    public GenreDto updateGenre(int genreId, GenreDto genreDto) {
        return null;
    }

    @Override
    public void DeleteGenre(int GenreId) {

    }

    private GenreDto mapToDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        return genreDto;
    }

    private Genre mapToEntity(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName());
        return genre;
    }
}
