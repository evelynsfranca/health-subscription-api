package com.healthsubscriptionapi.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsubscriptionapi.facade.ProductFacade;
import com.healthsubscriptionapi.facade.dto.product.ProductToCreateDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToSimpleDTO;
import com.healthsubscriptionapi.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @PostMapping
    private ResponseEntity<ProductToSimpleDTO> create(@Valid @RequestBody ProductToCreateDTO dto) {
        ProductToSimpleDTO result = productFacade.save(dto);
        return new ResponseEntity<ProductToSimpleDTO>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> get(@PathVariable String id) {
        Product result = productFacade.get(id);
        return new ResponseEntity<Product>(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAll() {
        List<Product> result = productFacade.getAll();
        return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
    }
}
