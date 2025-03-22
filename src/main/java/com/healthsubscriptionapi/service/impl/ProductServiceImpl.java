package com.healthsubscriptionapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthsubscriptionapi.model.Partner;
import com.healthsubscriptionapi.model.Product;
import com.healthsubscriptionapi.repository.PartnerRepository;
import com.healthsubscriptionapi.repository.ProductRepository;
import com.healthsubscriptionapi.service.ProductService;
import com.healthsubscriptionapi.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PartnerRepository partnerRepository;

    @Override
    public Product save(Product product) {
        Partner partner = partnerRepository.findById(product.getPartner().getId())
                .orElseThrow(() -> new NotFoundException("Partner not found."));
        product.setPartner(partner);
        return productRepository.save(product);
    }

    @Override
    public Product get(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found."));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllByClientId(String clientId) {
        return productRepository.findAllByClientId(clientId);
    }
}
