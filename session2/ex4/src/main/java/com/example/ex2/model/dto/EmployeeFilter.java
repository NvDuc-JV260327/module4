package com.example.ex2.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeFilter {
    private String name;
    private String department;

    public EmployeeFilter() {
    }

    public EmployeeFilter(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
