package com.example.project2.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя автора не может быть пустым")
    @Size(min = 2, max = 255, message = "Имя автора должно быть от 2 до 255 символов")
    private String name;

    private Boolean deleted = false;


    public @NotBlank(message = "Имя автора не может быть пустым") @Size(min = 2, max = 255, message = "Имя автора должно быть от 2 до 255 символов") String getName() {
        return name;
    }
}