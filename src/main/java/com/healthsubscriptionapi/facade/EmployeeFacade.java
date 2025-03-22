package com.healthsubscriptionapi.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsubscriptionapi.facade.dto.employee.EmployeeToCreateDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToGetDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToSimpleDTO;
import com.healthsubscriptionapi.facade.mapper.EmployeeMapper;
import com.healthsubscriptionapi.facade.validation.employee.CreateEmployeeFormsValidation;
import com.healthsubscriptionapi.model.Employee;
import com.healthsubscriptionapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {

    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;
    private final CreateEmployeeFormsValidation createEmployeeFormsValidation;

    @Transactional
    public EmployeeToSimpleDTO save(EmployeeToCreateDTO dto) {
        createEmployeeFormsValidation.create(dto);
        Employee entity = employeeMapper.toCreateEntity(dto);

        Employee saved = employeeService.save(entity);
        return employeeMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public EmployeeToGetDTO get(String id) {
        Employee entity = employeeService.get(id);
        return employeeMapper.toGetDto(entity);
    }

    @Transactional(readOnly = true)
    public List<EmployeeToGetAllDTO> getAll() {
        return employeeService.getAll().stream()
                .map(employeeMapper::toGetAllDto)
                .collect(Collectors.toList());
    }

}
