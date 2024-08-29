package com.example.springweb.service;

import com.example.springweb.entity.Client;
import com.example.springweb.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;


    public Client save(Client client) {
        return clientRepo.save(client);
    }
    public Optional<Client> findById(Long id) {
        return clientRepo.findById(id);
    }

    public Optional<Client> findByEmail(String email) {
        return clientRepo.findByEmail(email);
    }
    public List<Client> findAll() {
        return clientRepo.findAll();
    }
    public void deleteById(Long id) {
        clientRepo.deleteById(id);
    }
}
