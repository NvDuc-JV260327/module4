package com.example.ex1.service;

import com.example.ex1.model.Author;
import com.example.ex1.repository.AuthorRepository;
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
}
