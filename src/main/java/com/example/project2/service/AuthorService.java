package com.example.project2.service;

import com.example.project2.model.Author;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);
}