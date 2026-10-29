package com.example.ex1.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeCreateDTO {
    @NotBlank(message = "Tên nhân viên không được để trống")
    private String fullName;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @Pattern(regexp = "^0[35789]\\d{8}$", message = "Số điện thoại không đúng định dạng")
    private String phone;
    @Min(value = 5000000, message = "Lương từ 5000000 trở lên")
    private Double salary;
    @NotNull
    private Long departmentId;
}
