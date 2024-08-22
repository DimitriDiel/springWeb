package com.example.springweb.repository;

import com.example.springweb.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {


    public Optional<Client> findByEmail(String email);
}
