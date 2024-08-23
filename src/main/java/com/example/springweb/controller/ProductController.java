package com.example.springweb.controller;

import com.example.springweb.entity.Product;
import com.example.springweb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{product-id}")
    public Optional<Product> findById(@PathVariable(name = "product-id") Long id) {
        return productService.findById(id);
    }

    @GetMapping("/find-by-name")
    public Optional<Product> findByName(@RequestParam(value = "productName") String name) {
        return productService.findByName(name);
    }

    @GetMapping("/find-by-category")
    public List<Product> findByCategory(@RequestParam(value = "categoryName") String categoryName) {
        return productService.findByCategory(categoryName);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
