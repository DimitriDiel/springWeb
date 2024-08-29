package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDto {

    private String partnerEmail;
    private String productName;
    private String productDescription;
    private String productCategory;
    private double productPrice;
    private int productQuantity;

}
