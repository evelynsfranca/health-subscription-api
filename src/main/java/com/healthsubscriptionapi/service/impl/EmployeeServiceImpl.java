package com.healthsubscriptionapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthsubscriptionapi.model.Address;
import com.healthsubscriptionapi.model.Employee;
import com.healthsubscriptionapi.model.enumeration.PartnerName;
import com.healthsubscriptionapi.repository.AddressRepository;
import com.healthsubscriptionapi.repository.EmployeeRepository;
import com.healthsubscriptionapi.repository.ProductRepository;
import com.healthsubscriptionapi.service.EmployeeService;
import com.healthsubscriptionapi.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    @Override
    public Employee save(Employee employee) {

        employee.getProducts().stream()
                .map(it -> productRepository.findById(it.getId())
                        .orElseThrow(() -> new NotFoundException("Product not found.")))
                .filter(it -> it.getPartner().getName().equals(PartnerName.PAMPULHA_INTRAMEDICA))
                .findAny()
                .ifPresent(it -> {
                    Address address = addressRepository.save(employee.getAddress());
                    employee.setAddress(address);
                });

        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found."));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
