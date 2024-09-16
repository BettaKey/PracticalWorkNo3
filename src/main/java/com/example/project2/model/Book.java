package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название книги не может быть пустым")
    @Size(min = 3, max = 255, message = "Название книги должно быть от 3 до 255 символов")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getAuthorsAsString() {
        return authors.stream().map(a -> a.getName()).collect(Collectors.joining(", "));
    }

    public String getGenresAsString() {
        return genres.stream().map(g -> g.getName()).collect(Collectors.joining(", "));
    }
}