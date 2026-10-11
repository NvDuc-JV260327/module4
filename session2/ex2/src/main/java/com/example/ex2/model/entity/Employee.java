package com.example.ex2.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private long id;
    private String fullName;
    private String email;
    private String department;

    public Employee() {
    }

    public Employee(long id, String fullName, String email, String department) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
    }
}
