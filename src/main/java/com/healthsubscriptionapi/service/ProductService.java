package com.healthsubscriptionapi.service;

import java.util.List;

import com.healthsubscriptionapi.model.Product;

public interface ProductService {

    Product save(Product product);

    Product get(String id);

    List<Product> getAll();

    List<Product> getAllByClientId(String clientId);
}
