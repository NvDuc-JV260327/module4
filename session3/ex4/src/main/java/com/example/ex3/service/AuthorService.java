package com.example.ex3.service;

import com.example.ex3.model.entity.Author;
import com.example.ex3.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    public Author updateAuthor(int id, Author request) {
        Author author = authorRepository.findById(id);
        if(author == null) {
            return null;
        } else {
            author.setName(request.getName());
            author.setEmail(request.getEmail());
            return author;
        }
    }
}
