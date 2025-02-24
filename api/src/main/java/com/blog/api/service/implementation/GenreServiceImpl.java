package com.blog.api.service.implementation;

import com.blog.api.dto.GenreDto;
import com.blog.api.models.Genre;
import com.blog.api.repository.GenreRepository;
import com.blog.api.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
