package com.example.springweb.service;

import com.example.springweb.dto.SupplierDto;
import com.example.springweb.entity.Supplier;
import com.example.springweb.repository.SupplierRepo;
import com.example.springweb.service.util.SupplierConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepo supplierRepo;
    private final SupplierConverter supplierConverter;

    public Supplier save(SupplierDto supplierDto) {
        return supplierRepo.save(supplierConverter.convertFromDto(supplierDto));
    }

    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    public Optional<Supplier> findById(Long id) {
        return supplierRepo.findById(id);
    }

    public Optional<Supplier> findByEmail(String email) {
       return supplierRepo.findByEmail(email);
    }

    public void deleteById(Long id) {
        supplierRepo.deleteById(id);
    }
}
