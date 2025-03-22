package com.healthsubscriptionapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthsubscriptionapi.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
    
    Optional<Client> findByName(String name);
}
