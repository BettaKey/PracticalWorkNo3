package com.example.project2.controller;

import com.example.project2.model.Book;
import com.example.project2.model.IssuedBook;
import com.example.project2.model.Reader;
import com.example.project2.service.BookService;
import com.example.project2.service.IssuedBookService;
import com.example.project2.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/issuedBooks")
public class IssuedBookController {

    @Autowired
    private IssuedBookService issuedBookService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public String getAllIssuedBooks(Model model) {
        List<IssuedBook> issuedBooks = issuedBookService.getAllIssuedBooks();
        model.addAttribute("issuedBooks", issuedBooks);
        return "issuedBooks";
    }

    @GetMapping("/{id}")
    public String getIssuedBookById(@PathVariable Long id, Model model) {
        IssuedBook issuedBook = issuedBookService.getIssuedBookById(id);
        model.addAttribute("issuedBook", issuedBook);
        return "issuedBook";
    }

    @GetMapping("/add")
    public String addIssuedBook(Model model) {
        List<Book> books = bookService.getAllBooks();
        List<Reader> readers = readerService.getAllReaders();
        model.addAttribute("books", books);
        model.addAttribute("readers", readers);
        model.addAttribute("issuedBook", new IssuedBook());
        return "addIssuedBook";
    }

    @PostMapping("/add")
    public String saveIssuedBook(@Valid IssuedBook issuedBook, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addIssuedBook";
        }
        issuedBookService.saveIssuedBook(issuedBook);
        return "redirect:/issuedBooks";
    }

    @GetMapping("/delete/{id}")
    public String deleteIssuedBook(@PathVariable Long id) {
        issuedBookService.deleteIssuedBook(id);
        return "redirect:/issuedBooks";
    }

    @GetMapping("/{id}/edit")
    public String editIssuedBook(@PathVariable Long id, Model model) {
        IssuedBook issuedBook = issuedBookService.getIssuedBookById(id);
        List<Book> books = bookService.getAllBooks();
        List<Reader> readers = readerService.getAllReaders();

        model.addAttribute("books", books);
        model.addAttribute("readers", readers);
        model.addAttribute("issuedBook", issuedBook);
        return "editIssuedBook";
    }

    @PostMapping("/{id}/edit")
    public String updateIssuedBook(@Valid IssuedBook issuedBook, BindingResult bindingResult, @PathVariable Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "editIssuedBook";
        }
        issuedBookService.saveIssuedBook(issuedBook);
        return "redirect:/issuedBooks";
    }
}