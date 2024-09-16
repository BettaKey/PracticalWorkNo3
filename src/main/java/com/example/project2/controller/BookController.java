package com.example.project2.controller;

import com.example.project2.model.Author;
import com.example.project2.model.Book;
import com.example.project2.model.Genre;
import com.example.project2.service.AuthorService;
import com.example.project2.service.BookService;
import com.example.project2.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}