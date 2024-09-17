package com.example.project2.service;

import com.example.project2.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);

    void addAuthorToBook(Long bookId, Long authorId);

    void removeAuthorFromBook(Long bookId, Long authorId);

    void addGenreToBook(Long bookId, Long genreId);

    void removeGenreFromBook(Long bookId, Long genreId);
}