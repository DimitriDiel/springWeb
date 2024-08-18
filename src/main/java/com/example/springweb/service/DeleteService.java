package com.example.springweb.service;

import com.example.springweb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteService {

    private final ProductRepository productRepository;

    public boolean deleteProduct(Integer id) {
        return productRepository.deleteProductById(id);

    }

}
