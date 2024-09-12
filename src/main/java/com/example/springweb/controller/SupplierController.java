package com.example.springweb.controller;

import com.example.springweb.dto.SupplierDto;
import com.example.springweb.entity.Supplier;
import com.example.springweb.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody SupplierDto supplierDto) {
       return new ResponseEntity<>(supplierService.save(supplierDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supplier>> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }
    @GetMapping("/find-by-email")
    public ResponseEntity<Optional<Supplier>> findByEmail(@RequestParam(value = "email") String email) {
        return ResponseEntity.ok(supplierService.findByEmail(email));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        supplierService.deleteById(id);
    }


}
