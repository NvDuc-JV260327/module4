package com.example.ex3.service;

import com.example.ex3.model.entity.Author;
import com.example.ex3.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    public boolean deleteAuthor(int id) {
        Author author = authorRepository.findById(id);
        if(author.getName().equalsIgnoreCase("admin")) {
            return false;
        } else {
            authorRepository.delete(id);
            return true;
        }
    }

    public List<Author> searchAuthorByName(String keyword) {
        List<Author> result = new ArrayList<>();
        result = authorRepository.findAll().stream().filter(
                author -> author.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
        return result;
    }
}
