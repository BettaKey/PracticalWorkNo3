package com.example.project2.service;

import com.example.project2.model.Genre;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface GenreService {

    List<Genre> getAllGenres();

    Genre getGenreById(Long id);

    Genre saveGenre(Genre genre);

    void deleteGenre(Long id);
}