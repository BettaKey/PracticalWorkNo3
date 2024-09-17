package com.example.project2.controller;
import com.example.project2.model.Genre;
import com.example.project2.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public String getAllGenres(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping("/{id}")
    public String getGenreById(@PathVariable Long id, Model model) {
        Genre genre = genreService.getGenreById(id);
        model.addAttribute("genre", genre);
        return "genre";
    }

    @GetMapping("/add")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "addGenre";
    }

    @PostMapping("/add")
    public String saveGenre(@Valid Genre genre, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addGenre";
        }
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }

    @GetMapping("/{id}/edit")
    public String editGenre(@PathVariable Long id, Model model) {
        Genre genre = genreService.getGenreById(id);
        model.addAttribute("genre", genre);
        return "editGenre";
    }

    @PostMapping("/{id}/edit")
    public String updateGenre(@Valid Genre genre, BindingResult bindingResult, @PathVariable Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "editGenre";
        }
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }
}