package com.example.ex1.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentDTO {
    @NotBlank (message = "Họ tên không được để trống!")
    @Size (min = 5, max = 100, message = "Họ tên phải từ 5-100 ký tự")
    private String fullName;

    @NotBlank (message = "Chuyên ngành không được để trống")
    private String major;

    public StudentDTO() {}

    public StudentDTO(String fullName, String major) {
        this.fullName = fullName;
        this.major = major;
    }

    public String getFullName() {
        return fullName;
    }
    public String getMajor() {
        return major;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setMajor(String major) {
        this.major = major;
    }
}
