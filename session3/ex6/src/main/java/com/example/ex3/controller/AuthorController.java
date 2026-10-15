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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable int id, @RequestBody Author author) {
        if(authorService.updateAuthor(id, author) == null) {
            return new ResponseEntity<>("Không tìm thấy tác giả với id: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(authorService.updateAuthor(id, author), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
        if(authorService.getAuthorById(id) == null) {
            return new ResponseEntity<>("Không tìm thấy Id: " + id, HttpStatus.NOT_FOUND);
        } else {
            if(authorService.deleteAuthor(id)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("không được phép xóa tài khoản Admin!", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Author>> searchAuthorByName(@RequestParam String name) {
        return new ResponseEntity<>(authorService.searchAuthorByName(name), HttpStatus.OK);
    }
}
