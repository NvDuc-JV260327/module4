package com.example.ex1.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentDTO {
    @NotNull(message = "Tên phòng ban không được để trống")
    @Size(min = 5, max = 50, message = "Độ dài phải từ 5-50 ký tự")
    private String name;
    @Size(max = 100, message = "Tối đa 100 ký tự")
    private String description;
}
