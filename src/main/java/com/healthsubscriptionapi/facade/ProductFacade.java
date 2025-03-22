package com.healthsubscriptionapi.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsubscriptionapi.facade.dto.product.ProductToCreateDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToSimpleDTO;
import com.healthsubscriptionapi.facade.mapper.ProductMapper;
import com.healthsubscriptionapi.model.Product;
import com.healthsubscriptionapi.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final ProductService productService;

    @Transactional
    public ProductToSimpleDTO save(ProductToCreateDTO dto) {
        Product entity = productMapper.toCreateEntity(dto);
        Product saved = productService.save(entity);
        return productMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public Product get(String id) {
        return productService.get(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productService.getAll();
    }

}
