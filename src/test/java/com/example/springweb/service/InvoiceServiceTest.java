package com.example.springweb.service;

import com.example.springweb.dto.InvoiceResponseDto;
import com.example.springweb.repository.InvoiceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InvoiceServiceTest {

    private InvoiceService invoiceService;
    private InvoiceRepo invoiceRepo;
    private List<InvoiceResponseDto> dtoInvoices;

    @BeforeEach
    void setUp() {
        dtoInvoices = new ArrayList<>();
        invoiceRepo = mock(InvoiceRepo.class);
        invoiceService = mock(InvoiceService.class);

        when(invoiceService.getAllInvoices()).thenReturn(dtoInvoices);

    }

    @Test
    void createInvoice() {
    }

    @Test
    void getAllInvoicesEmpty() {
        assertEquals(dtoInvoices, invoiceService.getAllInvoices());
    }
}