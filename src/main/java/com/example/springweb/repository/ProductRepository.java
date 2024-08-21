package com.example.springweb.repository;

import com.example.springweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    Integer addProduct(Product product);

    List<Product> getProducts();

    Optional<Product> getProductById(Long id);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByCategory(String category);

//    boolean deleteProductById(Long id);


}
