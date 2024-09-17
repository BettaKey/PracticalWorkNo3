package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название жанра не может быть пустым")
    @Size(min = 2, max = 255, message = "Название жанра должно быть от 2 до 255 символов")
    private String name;

    public @NotBlank() @Size(min = 2, max = 100) String getName() {
        return name;
    }
}