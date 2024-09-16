package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя читателя не может быть пустым")
    @Size(min = 2, max = 255, message = "Имя читателя должно быть от 2 до 255 символов")
    private String name;

    @NotBlank(message = "Фамилия читателя не может быть пустой")
    @Size(min = 2, max = 255, message = "Фамилия читателя должна быть от 2 до 255 символов")
    private String surname;
}