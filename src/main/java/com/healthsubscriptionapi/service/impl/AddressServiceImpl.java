package com.healthsubscriptionapi.service.impl;

import org.springframework.stereotype.Service;

import com.healthsubscriptionapi.model.Address;
import com.healthsubscriptionapi.repository.AddressRepository;
import com.healthsubscriptionapi.service.AddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
