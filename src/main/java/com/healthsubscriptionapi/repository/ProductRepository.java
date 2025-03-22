package com.healthsubscriptionapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.healthsubscriptionapi.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'clients' :{'$ref' : 'clients' , '$id' : ?0}}")
    List<Product> findAllByClientId(String clientId);

    Optional<Product> findByName(String name);
}
