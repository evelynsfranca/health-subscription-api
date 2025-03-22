package com.healthsubscriptionapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthsubscriptionapi.model.Partner;
import com.healthsubscriptionapi.repository.PartnerRepository;
import com.healthsubscriptionapi.service.PartnerService;
import com.healthsubscriptionapi.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner get(String id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Partner not found."));
    }

    @Override
    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }
}
