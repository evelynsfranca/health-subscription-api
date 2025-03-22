package com.healthsubscriptionapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthsubscriptionapi.model.Partner;
import com.healthsubscriptionapi.model.enumeration.PartnerName;

public interface PartnerRepository extends MongoRepository<Partner, String> {

    Optional<Partner> findByName(PartnerName name);
}
