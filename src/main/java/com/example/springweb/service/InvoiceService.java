package com.example.springweb.service;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.InvoiceResponseDto;
import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.Invoice;
import com.example.springweb.entity.Product;
import com.example.springweb.repository.InvoiceRepo;
import com.example.springweb.service.exception.NotFoundException;
import com.example.springweb.service.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;
    private final ProductService productService;
    private final SupplierService supplierService;
    private final ClientService clientService;
    private final DtoConverter dtoConverter;

    @Transactional
    public InvoiceResponseDto createInvoice(InvoiceRequestDto invoiceRequestDto) {
        Invoice invoice = new Invoice();
        ProductDto productDto = dtoConverter.convertFromInvoiceDtoToProductDto(invoiceRequestDto);

        invoice.setPartnerEmail(invoiceRequestDto.getPartnerEmail());
        invoice.setDate(LocalDateTime.now());
        if(supplierService.findByEmail(invoiceRequestDto.getPartnerEmail()).isPresent()) {
            invoice.setType("Приход");
            productDto.setSupplier(supplierService.findByEmail(invoiceRequestDto.getPartnerEmail()).get());
            Product productForAdd = productService.addProduct(productDto);
            invoice.setProduct(productForAdd);
            invoiceRepo.save(invoice);

        } else if (clientService.findByEmail(invoiceRequestDto.getPartnerEmail()).isPresent()) {
            invoice.setType("Отгрузка");
                if (productService.findByName(invoiceRequestDto.getProductName()).isPresent()) {
                 invoice.setProduct(productService.findByName(invoiceRequestDto.getProductName()).get());
                 invoiceRepo.save(invoice);
                } else {
                    throw new NotFoundException("Товара с таким названием нет на складе");
                }

        } else {
            throw new NotFoundException("Контрагент с email: " + invoiceRequestDto.getPartnerEmail() + " в базе не найден, пожалуйста заведите нового контрагента");
        }

        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setId(invoice.getId());
        invoiceResponseDto.setDate(invoice.getDate());
        invoiceResponseDto.setInvoiceType(invoice.getType());

        return invoiceResponseDto;
    }

    public List<InvoiceResponseDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepo.findAll();
        List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
        for (Invoice invoice : invoices) {
            InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
            invoiceResponseDto.setId(invoice.getId());
            invoiceResponseDto.setDate(invoice.getDate());
            invoiceResponseDto.setInvoiceType(invoice.getType());
            invoiceResponseDtos.add(invoiceResponseDto);
        }
        return invoiceResponseDtos;
    }


}
