package com.example.springweb.dto;

import com.example.springweb.entity.Invoice;
import com.example.springweb.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private String category;
    private Supplier supplier;
    private double price;
    private int quantity;
}
