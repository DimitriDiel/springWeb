package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDto {
    private Long id;
    private String invoiceType;
    private LocalDateTime date;

}
