package com.healthsubscriptionapi.facade.mapper;

import org.mapstruct.Mapper;

import com.healthsubscriptionapi.facade.dto.employee.EmployeeToCreateDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToGetDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToSimpleDTO;
import com.healthsubscriptionapi.model.Employee;

@Mapper(componentModel = "spring", uses = { AddressMapper.class, EmployeeMapper.class, ProductMapper.class })
public interface EmployeeMapper {

    Employee toCreateEntity(EmployeeToCreateDTO dto);

    EmployeeToSimpleDTO toSimṕleDto(Employee entity);

    EmployeeToGetDTO toGetDto(Employee entity);

    EmployeeToGetAllDTO toGetAllDto(Employee entity);
}
