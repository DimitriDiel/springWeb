package com.example.springweb.service.util;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    public ProductDto convertFromInvoiceDtoToProductDto(InvoiceRequestDto invoiceRequestDto) {
        ProductDto productDto = new ProductDto();
        productDto.setName(invoiceRequestDto.getProductName());
        productDto.setCategory(invoiceRequestDto.getProductCategory());
        productDto.setPrice(invoiceRequestDto.getProductPrice());
        productDto.setQuantity(invoiceRequestDto.getProductQuantity());
        productDto.setDescription(invoiceRequestDto.getProductDescription());
        return productDto;
    }
}
