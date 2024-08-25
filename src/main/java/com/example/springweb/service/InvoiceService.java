package com.example.springweb.service;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.InvoiceResponseDto;
import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.Invoice;
import com.example.springweb.entity.Product;
import com.example.springweb.repository.InvoiceRepo;
import com.example.springweb.service.exception.NotFoundException;
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
        productDto.setDescription(invoiceRequestDto.getProductDescription());

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


}
