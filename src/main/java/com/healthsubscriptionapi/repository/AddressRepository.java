package com.healthsubscriptionapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthsubscriptionapi.model.Address;

public interface AddressRepository extends MongoRepository<Address, String> {
}
