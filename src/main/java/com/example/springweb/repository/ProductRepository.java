package com.example.springweb.repository;

import com.example.springweb.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Integer addProduct(Product product);

    List<Product> getProducts();

    Optional<Product> getProductById(Integer id);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByCategory(String category);

    boolean deleteProductById(Integer id);


}
