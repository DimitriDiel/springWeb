package com.example.springweb.controller;

import com.example.springweb.dto.SupplierDto;
import com.example.springweb.entity.Supplier;
import com.example.springweb.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public Supplier addSupplier(@RequestBody SupplierDto supplierDto) {
       return supplierService.save(supplierDto);
    }


}
