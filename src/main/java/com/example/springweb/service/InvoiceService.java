package com.example.springweb.service;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.InvoiceResponseDto;
import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.Invoice;
import com.example.springweb.repository.InvoiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;
    private final ProductService productService;
    private final SupplierService supplierService;
    private final ClientService clientService;

    public InvoiceResponseDto createInvoice(InvoiceRequestDto invoiceRequestDto) {
        Invoice invoice = new Invoice();
        ProductDto productDto = new ProductDto();
        productDto.setName(invoiceRequestDto.getProductName());
        productDto.setCategory(invoiceRequestDto.getProductCategory());
        productDto.setPrice(invoiceRequestDto.getProductPrice());
        productDto.setQuantity(invoiceRequestDto.getProductQuantity());

        invoice.setPartnerEmail(invoiceRequestDto.getPartnerEmail());
        invoice.setDate(LocalDateTime.now());
        if(supplierService.findByEmail(invoiceRequestDto.getPartnerEmail()).isPresent()) {
            invoice.setType("Приход");
            productDto.setSupplier(supplierService.findByEmail(invoiceRequestDto.getPartnerEmail()).get());
            productDto.setInvoice(invoice);
            invoice.setProduct(productService.addProduct(productDto));
        } else if (clientService.findByEmail(invoiceRequestDto.getPartnerEmail()).isPresent()) {
            invoice.setType("Отгрузка");
                if (productService.findByName(invoiceRequestDto.getProductName()).isPresent()) {
                invoice.setProduct(productService.findByName(invoiceRequestDto.getProductName()).get());
                } else {
                    throw new RuntimeException("Товара с таким названием нет на складе");
                }

        } else {
            throw new RuntimeException("Контрагент с email: " + invoiceRequestDto.getPartnerEmail() + " в базе не найден, пожалуйста заведите нового контрагента");
        }

        invoiceRepo.save(invoice);

        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setId(invoice.getId());
        invoiceResponseDto.setDate(invoice.getDate());
        invoiceResponseDto.setInvoiceType(invoice.getType());

        return invoiceResponseDto;
    }

}
