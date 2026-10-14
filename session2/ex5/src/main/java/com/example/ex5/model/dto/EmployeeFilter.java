package com.example.ex5.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
