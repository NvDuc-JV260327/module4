package com.example.ex3.controller;

import com.example.ex3.model.dto.request.BookRequestDTO;
import com.example.ex3.model.entity.Book;
import com.example.ex3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        return new ResponseEntity<>(bookService.addBook(bookRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        if(bookService.getBookById(id).isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy sách có id: " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
        }
    }
}
