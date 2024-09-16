package com.example.project2.controller;

import com.example.project2.model.Reader;
import com.example.project2.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public String getAllReaders(Model model) {
        List<Reader> readers = readerService.getAllReaders();
        model.addAttribute("readers", readers);
        return "readers";
    }

    @GetMapping("/{id}")
    public String getReaderById(@PathVariable Long id, Model model) {
        Reader reader = readerService.getReaderById(id);
        model.addAttribute("reader", reader);
        return "reader";
    }

    @GetMapping("/add")
    public String addReader(Model model) {
        model.addAttribute("reader", new Reader());
        return "addReader";
    }

    @PostMapping("/add")
    public String saveReader(@Valid Reader reader, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addReader";
        }
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    @GetMapping("/delete/{id}")
    public String deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
        return "redirect:/readers";
    }
}