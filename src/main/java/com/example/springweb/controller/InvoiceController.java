package com.example.springweb.controller;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.InvoiceResponseDto;
import com.example.springweb.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public InvoiceResponseDto createInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto) {
        return invoiceService.createInvoice(invoiceRequestDto);

    }

}
