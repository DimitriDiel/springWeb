package com.example.springweb.service;

import com.example.springweb.entity.Supplier;
import com.example.springweb.repository.SupplierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepo supplierRepo;

    public Optional<Supplier> findByEmail(String email) {
       return supplierRepo.findByEmail(email);
    }
}
