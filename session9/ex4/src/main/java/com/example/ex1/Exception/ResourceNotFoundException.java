package com.example.ex1.Exception;

// lỗi tài nguyên k tồn tại
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
