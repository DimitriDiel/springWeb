package com.example.springweb.service.util;

import com.example.springweb.dto.ProductDto;
import com.example.springweb.dto.SupplierDto;
import com.example.springweb.entity.Product;
import com.example.springweb.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter {

    public Supplier convertFromDto (SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setPhone(supplierDto.getPhone());
        supplier.setEmail(supplierDto.getEmail());
        return supplier;
    }
}
