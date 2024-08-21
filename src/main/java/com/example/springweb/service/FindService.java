package com.example.springweb.service;

import com.example.springweb.entity.Product;
import com.example.springweb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.getProducts();
    }
    public Optional<Product> findById(Long id) {
        return productRepository.getProductById(id);
    }
    public List<Product> findByName(String name) {
       return productRepository.getProductsByName(name);
    }
    public List<Product> findByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }


}
