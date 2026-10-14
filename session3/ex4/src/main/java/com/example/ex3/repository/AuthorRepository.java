package com.example.ex3.repository;

import com.example.ex3.model.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        authors.add(new Author(1, "author1", "author1@gmail.com"));
        authors.add(new Author(2, "author2", "author2@gmail.com"));
        authors.add(new Author(3, "author3", "author3@gmail.com"));
    }

    public List<Author> findAll() {
        return authors;
    }

    public void save(Author author) {
        authors.add(author);
    }

    public Author findById(int id) {
        for (Author author : authors) {
            if(author.getId() == id) {
                return author;
            }
        }
        return null;
    }
}
