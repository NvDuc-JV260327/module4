package com.example.ex1.controller;

import com.example.ex1.model.Author;
import com.example.ex1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

}
