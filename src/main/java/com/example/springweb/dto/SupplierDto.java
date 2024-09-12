package com.example.springweb.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    @Size(min = 2, max = 20, message = "Имя поставщика должно быть в диапазоне 3 -20 символов")
    private String name;
    private String address;
    private String phone;
    private String email;
}
