package com.example.ex1.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    private String email;

    public Author() {
    }

    public Author(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
