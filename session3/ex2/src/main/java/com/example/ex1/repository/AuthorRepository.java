package com.example.ex1.repository;

import com.example.ex1.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        authors.add(new Author(1, "Author1", "author1@gmail.com"));
        authors.add(new Author(2, "Author2", "author2@gmail.com"));
        authors.add(new Author(3, "Author3", "author3@gmail.com"));
    }

    public List<Author> findAll() {
        return authors;
    }

    public void save(Author author) {
        authors.add(author);
    }
}
