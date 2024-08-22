package com.example.springweb.repository;

import com.example.springweb.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
}
