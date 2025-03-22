package com.healthsubscriptionapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthsubscriptionapi.model.Client;
import com.healthsubscriptionapi.repository.ClientRepository;
import com.healthsubscriptionapi.service.ClientService;
import com.healthsubscriptionapi.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client get(String id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found."));
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
