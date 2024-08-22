package com.example.springweb.service;

import com.example.springweb.entity.Client;
import com.example.springweb.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;


    public Optional<Client> findByEmail(String email) {
        return clientRepo.findByEmail(email);
    }
}
