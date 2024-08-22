package com.example.springweb.repository;

import com.example.springweb.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {


    public Optional<Supplier> findByEmail(String email);
}
