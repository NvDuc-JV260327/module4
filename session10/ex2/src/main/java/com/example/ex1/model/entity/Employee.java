package com.example.ex1.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private Long id;
    private String fullName;
    private Double salary;
}
