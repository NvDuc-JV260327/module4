package com.example.ex1.controller;

import com.example.ex1.model.Author;
import com.example.ex1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        return ResponseEntity.ok(authorService.getAllAuthor());
    }
}
