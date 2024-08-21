package com.example.springweb.controller;

import com.example.springweb.dto.RequestDto;
import com.example.springweb.entity.Product;
import com.example.springweb.service.AddProductService;
import com.example.springweb.service.DeleteService;
import com.example.springweb.service.FindService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final AddProductService addProductService;
    private final DeleteService deleteService;
    private final FindService findService;

    @PostMapping("/add-new")
    public Product addNew(@RequestBody RequestDto requestDto) {
        return addProductService.addProduct(requestDto);
    }
    @GetMapping
    public List<Product> findAll() {
        return findService.findAll();
    }

    @GetMapping("/{product-id}")
    public Optional<Product> findById(@PathVariable(name = "product-id") Long id) {
        return findService.findById(id);
    }

    @GetMapping("/find-by-name")
    public List<Product> findByName(@RequestParam(value = "productName") String name) {
        return findService.findByName(name);
    }

    @GetMapping("/find-by-category")
    public List<Product> findByCategory(@RequestParam(value = "categoryName") String categoryName) {
        return findService.findByCategory(categoryName);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        deleteService.deleteProduct(id);
    }
}
