package com.healthsubscriptionapi.facade.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.healthsubscriptionapi.facade.dto.client.ClientToCreateDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToCreateEmployeeDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToGetDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToSimpleDTO;
import com.healthsubscriptionapi.model.Client;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, PartnerMapper.class })
public interface ClientMapper {

    Client toCreateEntity(ClientToCreateDTO dto);

    ClientToSimpleDTO toSimṕleDto(Client entity);

    @Mapping(source = "products", target = "products")
    ClientToGetDTO toGetDto(Client entity);

    @Mapping(source = "products", target = "products")
    ClientToGetAllDTO toGetAllDto(Client entity);

    Client toCreateEmployeeEntity(ClientToCreateEmployeeDTO dto);
}
