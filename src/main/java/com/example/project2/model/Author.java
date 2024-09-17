package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank()
    @Size(min = 2, max = 100)
    private String name;

    private Boolean deleted = false;

    public @NotBlank() @Size(min = 2, max = 100) String getName() {
        return name;
    }
}