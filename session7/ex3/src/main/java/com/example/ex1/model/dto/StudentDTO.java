package com.example.ex1.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StudentDTO {
    @NotBlank (message = "Họ tên không được để trống!")
    @Size (min = 5, max = 100, message = "Họ tên phải từ 5-100 ký tự")
    private String fullName;

    @NotBlank (message = "Chuyên ngành không được để trống")
    private String major;

    @Min (value = 18, message = "Sinh viên phải 18 tuổi trở lên")
    private int age;

    @Min (value = 0, message = "Điểm GPA phải nằm trong khoảng 0 - 10")
    @Max (value = 10, message = "Điểm GPA phải nằm trong khoảng 0 - 10")
    private Double gpa;

    @Pattern (regexp = "^SV\\d{4}$", message = "Mã sinh viên phải có dạng SVxxxx")
    private String studentCode;

    public StudentDTO() {}

    public StudentDTO(String fullName, String major, int age, Double gpa, String studentCode) {
        this.fullName = fullName;
        this.major = major;
        this.age = age;
        this.gpa = gpa;
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }
    public String getMajor() {
        return major;
    }
    public int getAge() {
        return age;
    }
    public Double getGpa() {
        return gpa;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
