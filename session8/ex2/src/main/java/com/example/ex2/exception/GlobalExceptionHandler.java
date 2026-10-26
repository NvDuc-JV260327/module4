package com.example.ex2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // lỗi chia cho 0
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException arithmeticException) {
        return new ResponseEntity<>("Không thể chia cho 0!", HttpStatus.BAD_REQUEST);
    }

    // lỗi không phải số
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismathchException) {
        return new ResponseEntity<>("Dữ liệu nhập vào phải là số!", HttpStatus.BAD_REQUEST);
    }

    // lỗi khác
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Lỗi không xác định!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
