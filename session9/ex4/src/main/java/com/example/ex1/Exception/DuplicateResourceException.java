package com.example.ex1.Exception;

// lỗi trùng lặp
public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }
}
