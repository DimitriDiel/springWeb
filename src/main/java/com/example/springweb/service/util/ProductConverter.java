package com.example.springweb.service.util;

import com.example.springweb.dto.InvoiceRequestDto;
import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convertFromDto (ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setSupplier(productDto.getSupplier());
        product.setQuantity(productDto.getQuantity());
        product.setInvoice(productDto.getInvoice());
        return product;
    }
}
