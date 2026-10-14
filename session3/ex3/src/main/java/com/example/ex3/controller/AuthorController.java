package com.example.ex3.controller;

import com.example.ex3.model.entity.Author;
import com.example.ex3.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        return new ResponseEntity<>(authorService.getAllAuthor(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable int id) {
        if(authorService.getAuthorById(id) != null) {
            return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy tác giả với Id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
