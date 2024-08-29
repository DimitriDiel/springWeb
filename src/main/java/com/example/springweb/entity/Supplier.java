package com.example.springweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Supplier name must be not blank")
    @Size(min = 2, max = 20, message = "Имя поставщика должно быть в диапазоне 3 -20 символов")
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    @Email
    private String email;

}
