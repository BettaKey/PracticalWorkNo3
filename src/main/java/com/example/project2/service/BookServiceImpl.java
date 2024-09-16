package com.example.project2.service;
import com.example.project2.model.Author;
import com.example.project2.model.Book;
import com.example.project2.model.Genre;
import com.example.project2.repository.AuthorRepository;
import com.example.project2.repository.BookRepository;
import com.example.project2.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void addAuthorToBook(Long bookId, Long authorId) {
        Book book = getBookById(bookId);
        Author author = authorRepository.findById(authorId).orElse(null);
        if (book != null && author != null) {
            book.getAuthors().add(author);
            bookRepository.save(book);
        }
    }

    @Override
    public void removeAuthorFromBook(Long bookId, Long authorId) {
        Book book = getBookById(bookId);
        Author author = authorRepository.findById(authorId).orElse(null);
        if (book != null && author != null) {
            book.getAuthors().remove(author);
            bookRepository.save(book);
        }
    }

    @Override
    public void addGenreToBook(Long bookId, Long genreId) {
        Book book = getBookById(bookId);
        Genre genre = genreRepository.findById(genreId).orElse(null);
        if (book != null && genre != null) {
            book.getGenres().add(genre);
            bookRepository.save(book);
        }
    }

    @Override
    public void removeGenreFromBook(Long bookId, Long genreId) {
        Book book = getBookById(bookId);
        Genre genre = genreRepository.findById(genreId).orElse(null);
        if (book != null && genre != null) {
            book.getGenres().remove(genre);
            bookRepository.save(book);
        }
    }
}