package com.example.springweb.repository;


import com.example.springweb.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryMap implements ProductRepository {

private Integer productId = 0;
private Map<Integer, Product> products = new HashMap<>();

    @Override
    public Integer addProduct(Product product) {
        product.setId(++productId);
        products.put(productId, product);
        return productId;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return products.values().stream()
                .filter(product -> product.getName().equals(name))
                .toList();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products.values().stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    @Override
    public boolean deleteProductById(Integer id) {
        return products.remove(id) != null;
    }
}
