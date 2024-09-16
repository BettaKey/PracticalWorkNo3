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
}