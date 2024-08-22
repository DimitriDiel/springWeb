package com.example.springweb.service;


import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.Product;
import com.example.springweb.repository.ProductRepository;
import com.example.springweb.service.util.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public Product addProduct(ProductDto productDto) {
        return productConverter.convertFromDto(productDto);
    }

    public List<Product> findAll() {
        return productRepository.getProducts();
    }
    public Optional<Product> findById(Long id) {
        return productRepository.getProductById(id);
    }
    public Optional<Product> findByName(String name) {
       return productRepository.getProductsByName(name);
    }
    public List<Product> findByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
