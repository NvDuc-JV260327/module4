package com.example.ex2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/math")
public class MathController {
    @GetMapping("/divide")
    public ResponseEntity<Integer> divide(
            @RequestParam("a") int a,
            @RequestParam("b") int b
    ) {
        return ResponseEntity.ok(a / b);
    }
}
