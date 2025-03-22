package com.healthsubscriptionapi.facade.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.healthsubscriptionapi.facade.dto.product.ProductToCreateDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToCreateEmployeeDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToGetDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToSimpleDTO;
import com.healthsubscriptionapi.model.Product;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, PartnerMapper.class })
public interface ProductMapper {

    @Mapping(source = "partner", target = "partner")
    Product toCreateEntity(ProductToCreateDTO dto);

    ProductToSimpleDTO toSimṕleDto(Product entity);

    @Mapping(source = "partner", target = "partner")
    ProductToGetDTO toGetDto(Product entity);

    @Mapping(source = "partner", target = "partner")
    ProductToGetAllDTO toGetAllDto(Product entity);

    Product toCreateEmployeeEntity(ProductToCreateEmployeeDTO dto);
}
