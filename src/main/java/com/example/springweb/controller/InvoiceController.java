package com.example.springweb.controller;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.InvoiceResponseDto;
import com.example.springweb.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponseDto> createInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto) {
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceRequestDto), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<InvoiceResponseDto>> getInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

}
