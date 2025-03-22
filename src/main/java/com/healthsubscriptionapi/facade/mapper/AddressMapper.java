package com.healthsubscriptionapi.facade.mapper;

import org.mapstruct.Mapper;

import com.healthsubscriptionapi.facade.dto.address.AddressToCreateEmployeeDTO;
import com.healthsubscriptionapi.model.Address;

@Mapper(componentModel = "spring", uses = { EmployeeMapper.class })
public interface AddressMapper {

    Address toCreateEntity(AddressToCreateEmployeeDTO dto);
}
