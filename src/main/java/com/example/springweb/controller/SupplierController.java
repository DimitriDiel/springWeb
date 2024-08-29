package com.example.springweb.controller;

import com.example.springweb.dto.SupplierDto;
import com.example.springweb.entity.Supplier;
import com.example.springweb.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public Supplier addSupplier(@RequestBody SupplierDto supplierDto) {
       return supplierService.save(supplierDto);
    }
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierService.findById(id);
    }
    @GetMapping("/find-by-email")
    public Optional<Supplier> findByEmail(@RequestParam(value = "email") String email) {
        return supplierService.findByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        supplierService.deleteById(id);
    }


}
