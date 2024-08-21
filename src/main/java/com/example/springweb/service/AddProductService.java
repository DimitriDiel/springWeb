package com.example.springweb.service;

import com.example.springweb.dto.RequestDto;
import com.example.springweb.entity.Product;
import com.example.springweb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddProductService {
    private final ProductRepository productRepository;

    public Product addProduct(RequestDto request) {
        Product newProduct = new Product(0, request.getName(), request.getDescription(), request.getCategory() , request.getPrice(), request.getQuantity());
        return productRepository.save(newProduct);
    }

}
