package com.example.ex1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private int id;
    private String name;
    private String email;

    public Author() {
    }

    public Author(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
