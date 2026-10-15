package com.example.ex3.service;

import com.example.ex3.model.dto.request.BookRequestDTO;
import com.example.ex3.model.entity.Author;
import com.example.ex3.model.entity.Book;
import com.example.ex3.repository.AuthorRepository;
import com.example.ex3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<?> addBook(BookRequestDTO bookRequestDTO) {
        Author author = authorRepository.findById(bookRequestDTO.getAuthorId()).orElse(null);
        if(author == null) {
            return new ResponseEntity<>("Tác giả không tồn tại!", HttpStatus.BAD_REQUEST);
        } else {
            Book newBook = new Book(null, bookRequestDTO.getTitle(), bookRequestDTO.getPrice(), author);
            return new ResponseEntity<>(bookRepository.save(newBook), HttpStatus.CREATED);
        }
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
}
